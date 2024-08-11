package sort_listt;
import java.util.*;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class sort_listt {
    public static ListNode createNode(int x, ListNode next) {
        return new ListNode(x, next);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Changed from `return null`
        }
        ListNode middleElement = middle(head);
        ListNode middle_next = middleElement.next;
        middleElement.next = null;
        
        ListNode start = sortList(head); // Fixed: sort the left part starting from head
        ListNode end = sortList(middle_next); // Fixed: sort the right part starting from middle_next
        return merge(start, end); // Fixed function name
    }

    private static ListNode middle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = null; // Head of the list
        Scanner sc = new Scanner(System.in);
        sort_listt s1 = new sort_listt();
        int n = 4;

        // Create the linked list by inserting new nodes at the head
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the data:");
            int x = sc.nextInt();
            head1 = createNode(x, head1); // Insert new node at the beginning of the list
        }

        // Print the original linked list
        ListNode head = head1;
        System.out.print("Original list: ");
        while (head != null) {
            System.out.print(head.val + " --> ");
            head = head.next;
        }
        System.out.println("null");

        // Sort the list
        ListNode sortedHead = s1.sortList(head1);

        // Print the sorted linked list
        System.out.print("Sorted list: ");
        while (sortedHead != null) {
            System.out.print(sortedHead.val + " --> ");
            sortedHead = sortedHead.next;
        }
        System.out.println("null");

        sc.close();
    }
}
