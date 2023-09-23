package patikaw6;

import java.util.*;

public class MyList<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    public MyList(Object[] array, int size) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = size;
    }
    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.array = new Object[capacity];
        this.size = 0;
    }
    public Object[] getArray() {
        return array;
    }
    public void setArray(Object[] array) {
        this.array = array;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getCapacity() {
        return array.length;
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (T) array[index];
    }
    public void add(T data) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = data;
    }
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T removedData = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return removedData;
    }
    public boolean set(int index, T data) {
        if (index < 0 || index >= size) {
            return false;
        }
        array[index] = data;
        return true;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }
    boolean isEmpty(){
        if(size==0){
            return true;
        };
        return false;
    }
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
    public T[] toArray() {
        return (T[]) Arrays.copyOf(array, size);
    }
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }
    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) {
            System.out.println("Invalid start and finish indices");
        }
        MyList<T> sublist = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            sublist.add(get(i));
        }
        return sublist;
    }
}
