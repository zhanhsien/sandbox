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

    /**
     * Adds a node at the end of the list
     * @param data - contents of the node
     */
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
    }

    /**
     * Inserts a node at the designated index
     * @param data - contents of the node
     * @param index - index of the node
     */
    public void insert(T data, int index) {
        //TODO: Unimplemented
    }

    /**
     * Replaces the contents of a node at the designated index
     * @param data - contents of the node
     * @param index - index of the node
     */
    public void set(T data, int index) {
        //TODO: Unimplemented
    }

    /**
     * Removes the matching node
     * @param data - contents of the node
     */
    public void remove(T data) {
        if(head == null) {
            throw new RuntimeException("There's nothing to remove");
        }
        //TODO: Unimplemented
    }

    /**
     * Removes the designated index from the list
     * @param index - index of the node
     */
    public void remove(int index) {
        if(head == null) {
            throw new RuntimeException("There's nothing to remove");
        }
        //TODO: Unimplemented
    }

    /**
     * Retrieves the first item of the list
     * @return contents of the node
     */
    public T peek() {
        Node<T> curr = head;
//        while (curr != tail){
//
//        }
        //TODO: Unimplemented
        return null;
    }

    /**
     * Retrieves and removes the first item of the list
     * @return contents of the node
     */
    public T pop() {
        //TODO: Unimplemented
        return null;
    }

    /**
     * Adds a node at the head of the list
     * @param data - contents of the node
     */
    public void push(T data) {
        //TODO: Unimplemented
    }

    public T get(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("You're out of bounds");
        }

        if(head == null) {
            throw new RuntimeException("There's nothing to get");
        }

        boolean headfirst = index <= (size / 2);
        Node<T> curr = headfirst ? head : tail ;

        if (headfirst) {
            for(int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }

        return curr.data;
    }

    public int indexOf(T find) {
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

    /**
     * Indicates whether a specific entry exists
     * @param data - contents of the node
     * @return boolean flag
     */
    public boolean contains(T data) {
        if (head == null) {
        }
            System.out.println("List contains no entries");
        //TODO: Unimplemented
        return false;
    }

    /**
     * Empties the contents of the list
     */
    public void clear() {
        //TODO: Unimplemented
    }

    /**
     * Copies the contents of the list
     */
    public LinkedList<T> clone() {
        //TODO: Unimplemented
        return null;
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
