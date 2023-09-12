package dsa.linkedlist;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode sentinel = new ListNode(-1);
        ListNode previous = sentinel;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                previous.next = list1;
                list1 = list1.next;
            } else {
                previous.next = list2;
                list2 = list2.next;
            }

            previous = previous.next;
        }

        if (list1 != null) {
            previous.next = list1;
        }

        if (list2 != null) {
            previous.next = list2;
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addFirst(4);
        list1.addFirst(2);
        list1.addFirst(1);

        LinkedList list2 = new LinkedList();
        list2.addFirst(4);
        list2.addFirst(3);
        list2.addFirst(1);

        ListNode list3 = mergeTwoLists(list1.getHead(), list2.getHead());
        LinkedList.print(list3);
    }
}
