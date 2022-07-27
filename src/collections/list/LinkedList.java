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
     * Inserts a node before the designated index
     * @param data - contents of the node
     * @param index - index of the node
     */
    public void insert(T data, int index) {

        Node<T> currentNode = search(index); // Current node is index 1
        Node<T> prevNode = currentNode.prev; // Prev node is index 0\

        // Severing links to both nodes by setting the previous and next references to null -> REDUNDANT
        prevNode.next = null;
        currentNode.prev = null;

        //Creating new node for our data to be stored in
        Node<T> insertedNode = new Node<>(data);

        //linking old nodes to new node
        prevNode.next = insertedNode;
        currentNode.prev = insertedNode;

        //linking new node back to the old ones
        insertedNode.next = currentNode;
        insertedNode.prev = prevNode;

    }

    /**
     * Replaces the contents of a node at the designated index
     * @param data - contents of the node
     * @param index - index of the node
     */
    public void set(T data, int index) {

        search(index).data = data;
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
    public T remove(int index) {
        if(head == null) {
            throw new RuntimeException("There's nothing to remove");
        }

        Node<T> removedNode = search(index);

//        store removedNode.prev and removedNode.next
//        cut ties to the removed node
//        establish new connections between the prev and next nodes

        Node<T> previousNode = removedNode.prev;
        Node<T> nextNode = removedNode.next;

        removedNode.prev=null;
        removedNode.next=null;

        previousNode.next = nextNode;
        nextNode.prev = previousNode;


//        LEFT OFF HERE
        

        return blah;
    }

   /**
     * Retrieves the first item of the list
     * @return contents of the node
     */
    public T peek() {

      return head == null ? null : head.data;
    }

    /**
     * Retrieves and removes the first item of the list
     * @return contents of the node
     */
    public T pop() {

        return remove(0);

    }

    /**
     * Adds a node at the head of the list
     * @param data - contents of the node
     */
    public void push(T data) {

        Node<T> newNode = new Node<>(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;

    }

    public Node<T> search(int index) {

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

        return curr;
    }

    public T get(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("You're out of bounds");
        }

        if(head == null) {
            throw new RuntimeException("There's nothing to get");
        }

       return search(index).data;

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
