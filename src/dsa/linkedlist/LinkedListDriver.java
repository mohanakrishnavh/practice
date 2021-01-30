package dsa.linkedlist;

public class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtIndex(0, 10);
        list.addAtIndex(0, 20);
        list.addAtIndex(1, 30);
        System.out.println(list.get(0));
    }
}
