import collections.list.GenericLinkedList;

import java.util.LinkedList;
//import collections.list.LinkedList;

public class Sandbox {
    /*
    TODO:
        remove a specific entry?
        contains?
        how can we make the get(int index) method more efficient?
            (Hint: It involves incorporating a Tail in addition to the Head to the LinkedList)
        what if we want to store more than a number?
     */

    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.add(9);
//        list.add(10);
//        list.add(11);
//        list.add(12);
//
//        try {
//            System.out.println("Index: " + list.findFirstIndexOf(6));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        list.print();

        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");

        try {
//            System.out.println("Index: " + list.findFirstIndexOf("Anything"));
            System.out.println("contains: " + list.contains("12"));
            System.out.println("getIndex: " + list.get(10));
        } catch (Exception e) {
            e.printStackTrace();
        }

        list.print();
    }
}
