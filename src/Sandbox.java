import collections.list.LinkedList;

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
        LinkedList<Integer> list = new LinkedList<>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);

        LinkedList<String> list2 = new LinkedList<>();
//
//        list2.add("Brandon");
//        list2.add("dude");

//        System.out.println(list.size());
        list.get(8);


        try {
            System.out.println("Index: " + list.indexOf(6));
        } catch (Exception e) {
            e.printStackTrace();
        }

//

//        REMOVING A SPECIFIC ENTRY
//        HAD TO MAKE REMOME/REM OF TYPE T AND PASS T DATA AS A PARAM LIKE IN GET
//        list2.remove("Brandon");
        list2.print();
    }
}
