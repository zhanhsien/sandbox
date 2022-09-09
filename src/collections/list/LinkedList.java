package collections.list;

import javax.xml.crypto.Data;
import java.security.PublicKey;

public class LinkedList<T extends Comparable<T>> {
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

        remove(indexOf(data));
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

        if (removedNode != head) {
            previousNode.next = nextNode;
        } else {
            head = nextNode;
        }

        if (removedNode != tail) {
            nextNode.prev = previousNode;
        } else {
            tail = previousNode;
        }

        size--;

        return removedNode.data;
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
            System.out.println("List contains no entries");
        }

        return (indexOf(data) > -1);
    }

    /**
     * Empties the contents of the list
     *
     * Want to start at head node, empty that node, progress to next node, empty that node, repeat until reaching tail node.
     */
    public void clear() {
      while (head != tail && head.data != null) {
          head.data = null;
          head = head.next;
          head.prev.next = null;
          head.prev = null;
      }

      if (head == tail && head.data != null) {
          head.data = null;
      }
    }

    /**
     * Copies the contents of the list
     *
     * Create new list, go node by node and set contents of new list to that of the other list
     *
     */
    public LinkedList<T> clone() {

        LinkedList<T> listClone = new LinkedList<>();
        Node<T> currClone = head;

        while (currClone != tail && currClone.data != null) {

            listClone.add(currClone.data);
            currClone = currClone.next;
        }

        if (currClone == tail && currClone.data != null) {
            listClone.add(currClone.data);
        }

        return listClone;
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
        System.out.println("");
    }

    int count = 0;

    public LinkedList<T> sort() {
        /*
        * Create New list
        * create lowestItem var
        * Clone OG list
        *
        * Create a for loop for i=<size
        * assign head to lowestItem var
        * go to next, if lower, reassign gender, if not, continue to next
        * iterate through until tail
        * if tail is not lowest, add lowestItem var to new list
        * remove lowest item from OG list
        *
        *           * */
        LinkedList<T> newList = new LinkedList<>();
        LinkedList<T> clonedList = clone();

        while (clonedList.size > 0){
            T lowestItem = findLowest(clonedList);
            newList.add(lowestItem);
            clonedList.remove(clonedList.indexOf(lowestItem));
        }

        return newList;
    }

    public T findLowest(LinkedList<T> templist){
        T lowestItem = null;
        for(int i = 0; i <= templist.size; i++ ){
            count++;
            if(lowestItem == null || lowestItem.compareTo(templist.get(i)) > 0){
                lowestItem = templist.get(i);
            }
        }
        return lowestItem;
    }

}