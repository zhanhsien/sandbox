package collections.list;

public class GenericLinkedList<T> {
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

        //FIFO
        Node<T> last = head;
        while(last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;
        tail = newNode;
        size++;

        //LIFO
//        head = newNode;
//        head.next = last;
    }

    public T remove() {
        if(head == null) {
            throw new RuntimeException("There's nothing to remove");
        }

        T rem = head.data;
        head = head.next;
        head.prev = null;
        return rem;
    }

    public T get(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("You're out of bounds");
        }

        if(head == null) {
            throw new RuntimeException("There's nothing to get");
        }

        boolean early = index <= ( size / 2 );
        Node<T> curr = early ? head : tail;

        if(early) {
            for(int i = 0; i < index; i++) {
                System.out.println("Iterate forward");
                curr = curr.next;
            }
        } else {
            for(int j = size; j > index; j--) {
                System.out.println("Iterate backward");
                curr = curr.prev;
            }
        }

        return curr.data;
    }

    public int findFirstIndexOf(T find) {
        int index = -1;
        for(int i = 0; i < size; i++) {
            T t = get(i);
            if(t == find || t.equals(find)) {
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

        Node<T> curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
