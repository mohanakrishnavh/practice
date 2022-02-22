package leetcode;

import dsa.linkedlist.ListNode;

public class LC0021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode sentinel = new ListNode(0);
        ListNode previous = sentinel;
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                previous.next = list1;
                previous = list1;
                list1 = list1.next;
            } else {
                previous.next = list2;
                previous = list2;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            previous.next = list1;
        }


        if (list2 != null) {
            previous.next = list2;
        }

        return sentinel.next;
    }
}
