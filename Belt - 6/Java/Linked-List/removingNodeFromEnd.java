/*
 * You are given a singly linked list, and your task is to remove the nth node from the end of the list and print the resulting list. Assume that n is always valid and within the range of the list's length. 
 * Input Format The
 * first line contains an integer n, the size of the linked list. The second
 * line contains n space-separated integers, representing the elements of the
 * linked list. The third line contains an integer k, the position of the node
 * to remove from the end of the list. Output Format Output the resulting linked
 * list after removing the nth node from the end. Constraints 1 <= n <= 10^5
 * -10^5 <= node.val <= 10^5 1 <= k <= n Note Your solution should be
 * implemented in a single pass and use O(1) auxiliary space.
 */

import java.util.*;

class removingNodeFromEnd {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner ob = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = ob.nextInt();

        Node head = new Node(0);
        input(head, n, ob);

        System.out.print("Enter k: ");
        int k = ob.nextInt();

        head = removeFromEnd(head, k);

        print(head);
        ob.close();
    }

    private static void input(Node head, int n, Scanner ob) {
        System.out.println("Enter the linked list:");

        Node curr = head;
        for (int i = 0; i < n; i++) {
            curr.data = ob.nextInt();
            if (i == n - 1)
                break;
            curr.next = new Node(0);
            curr = curr.next;
        }
    }

    private static Node removeFromEnd(Node head, int k) {

        // Dummy node to handle head removal cleanly
        Node dummy = new Node(0);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        // Move fast pointer k+1 steps ahead
        for (int i = 0; i <= k; i++) {
            fast = fast.next;
        }

        // Move both pointers together
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove kth node from end
        slow.next = slow.next.next;

        return dummy.next; // new head
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }
}
