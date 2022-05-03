package collections.list;

public class LinkedList {
    Node head;
    int size;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            size++;
            return;
        }

        //FIFO
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        size++;

        //LIFO
//        head = newNode;
//        head.next = last;
    }

    public int remove() {
        if(head == null) {
            throw new RuntimeException("There's nothing to remove");
        }

        int rem = head.data;
        head = head.next;
        return rem;
    }

    public int get(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("You're out of bounds");
        }

        if(head == null) {
            throw new RuntimeException("There's nothing to get");
        }

        Node curr = head;
        for(int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.data;
    }

    public int findFirstIndexOf(int find) {
        int index = 0;
        for(int i = 0; i < size; i++) {
            if(get(i) == find) {
                index = i;
            }
        }

        return index;
    }

    public int size() {
        return size;
    }

    public void print() {
        if(head == null) {
            System.out.println("list is empty");
        }

        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
