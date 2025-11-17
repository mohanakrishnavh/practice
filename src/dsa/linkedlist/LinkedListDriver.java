package dsa.linkedlist;

/**
 * LinkedListDriver
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LinkedListDriver {
    public static void main(String[] args) {
        // addFirst() - Add at the beginning of the list
        LinkedList list1 = new LinkedList();
        list1.addFirst(6);
        list1.addFirst(4);
        list1.addFirst(2);
        list1.print();

        // addLast() - Add at the end of the list
        LinkedList list2 = new LinkedList();
        list2.addLast(1);
        list2.addLast(3);
        list2.addLast(5);
        list2.addLast(7);
        list2.print();

        // addAtIndex() - Add at the given index
        LinkedList list3 = new LinkedList();
        list3.addAtIndex(10, 0);
        list3.addAtIndex(20, 1);
        list3.addAtIndex(15, 1);
        list3.print();

        // remove() - Remove the node at the given index
        LinkedList list4 = new LinkedList();
        list4.addLast(1);
        list4.addLast(10);
        list4.addAtIndex(100, 1);
        list4.addAtIndex(200, 2);
        list4.addAtIndex(300, 3);
        list4.addAtIndex(400, 4);
        list4.addAtIndex(500, 5);
        list4.addAtIndex(600, 6);
        list4.print();
        list4.remove(0);
        list4.print();
        list4.remove(6);
        list4.print();
        list4.remove(3);
        list4.print();

        // reverse() - Reverse a linked list
        LinkedList list5 = new LinkedList();
        list5.addFirst(100);
        list5.addFirst(75);
        list5.addFirst(50);
        list5.addFirst(25);
        list5.addFirst(0);
        list5.reverse();
        list5.print();

        LinkedList list6 = new LinkedList();
        list6.addFirst(100);
        list6.reverse();
        list6.print();

        LinkedList list7 = new LinkedList();
        list7.reverse();
        list7.print();

        // Recursively printing the elements of the list
        LinkedList.print(list1.getHead());
        System.out.println();

        // Recursively printing the elements of the list in reverse order
        LinkedList.print(list1.getHead(), true);
        System.out.println();

        // Recursively reverse the list
        LinkedList list8 = new LinkedList();
        list8.addFirst(5);
        list8.addFirst(4);
        list8.addFirst(3);
        list8.addFirst(2);
        list8.addFirst(1);
        list8.print();
        System.out.println();
        ListNode head = LinkedList.reverse(list8.getHead());
        LinkedList.print(head);
        System.out.println();
    }
}
