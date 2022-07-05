package collections.list;

public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    static class Node<T> {
        T data;
        Node<T> next;

        Node<T> prev;

        Node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }


    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        size++;
        tail = newNode;


        //LIFO
//        head = newNode;
//        head.next = last;
    }
//
//    public T remove(T data) {
//        if(head == null) {
//            throw new RuntimeException("There's nothing to remove");
//        }
//
//    }

//    public T getFirst(T data) {
//        Node<T> curr = head;
//        while (curr != tail){
//
//        }
//
//    }

    public T get(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("You're out of bounds");
        }

        if(head == null) {
            throw new RuntimeException("There's nothing to get");
        }

//        condition ? execute 1 : execute 2
         boolean headfirst = index<=(size/2);



        Node<T> curr = headfirst ? head : tail ;

        if (headfirst){
        for(int i = 0; i < index; i++) {
            curr = curr.next;
        }}
        else {
            for (int i = size; i >= index; i--) {
                System.out.println("I is :" + i);
                System.out.println(curr.data + "data");
                curr = curr.prev;

            }
        }

        return curr.data;
    }

    public int findFirstIndexOf(T find) {
        int index = -1;
        for(int i = 0; i < size; i++) {
            if(get(i).equals(find)) {
                index = i;
            }
        }

        return index;
    }

    public int size() {
        return size;
    }

//    public boolean contains(T data) {
//        if (head == null) {
//        }
//            System.out.println("List contains no entries");
//    }

    public void print() {
        if(head == null) {
            System.out.println("list is empty");
        }

        Node<T> curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
