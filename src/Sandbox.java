import collections.list.LinkedList;

public class Sandbox {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(6);
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(11);
        list.add(4);
        list.add(5);
        list.add(0);
        list.add(10);
        list.add(8);
        list.add(12);
        list.add(9);
        list.add(1);
//
//        try {
//            System.out.println("Index: " + list.indexOf(6));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        list.print();
//        list.clone().print();

        list.sort();


    }
}
