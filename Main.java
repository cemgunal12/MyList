package patikaw6;
public class Main{
    public static void main (String[]args){
        MyList<Integer> myList = new MyList<>();
        
        System.out.println("Liste Durumu : " + (myList.isEmpty() ? "Boş" : "Dolu"));

        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);

        System.out.println("Indeks : " + myList.indexOf(20));
        System.out.println("Indeks : " + myList.indexOf(50));
        System.out.println("Indeks : " + myList.lastIndexOf(40));

        System.out.println("Object dizisinin ilk elemanı : " + myList.get(0));

        System.out.println(myList.toString());

        System.out.println("Listemde 20 değeri : " + myList.contains(20));
        System.out.println("Listemde 120 değeri : " + myList.contains(120));

        myList.clear();
        System.out.println(myList.toString());
    }
}