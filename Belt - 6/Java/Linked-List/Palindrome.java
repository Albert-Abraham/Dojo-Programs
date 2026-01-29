/*
Given a singly linked list, determine if it is a palindrome. 
Palindrome: A palindrome is a word, sentence, verse, or even number that reads the same backward or forward. Input Format The first line contains an integer n, the size of the linked list. The second line contains n space-separated integers, representing the elements of the linked list. 
Output Format Output True if the linked list is a palindrome. Output False otherwise. 
Constraints 0 <= n <= 10^5 
The linked list elements can be integers of any value. 
Note: Your solution must be implemented in-place with O(1) auxiliary space complexity. You are restricted from copying the linked list's values into another data structure (like an array, vector, or list).
 */

import java.util.*;
public class palindrome {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Palindrome");
        Node head = new Node(0);
        input(head);
        
        System.out.println(check(head) ? "true" : "false");
        print(head);


    }
    private static void input(Node head){
        Scanner ob = new Scanner(System.in);
        System.out.print("enter n: ");
        int n = ob.nextInt();
        System.out.println("enter the linked list");
        for (int i = 0; i < n; i++) {
            head.data = ob.nextInt();
            if(i==n-1) break;
            Node next = new Node(0);
            head.next = next;
            head = next;
        }
        ob.close();
    }
    private static void print(Node head){
        while(head!=null){
            System.out.print(head.data + "->");
            head = head.next;
        }
    }
    private static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private static Node middleNode(Node head){
        Node fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static boolean check(Node head){
        
        Node middleNode = reverse(middleNode(head));
        Node x = middleNode;

        while(middleNode != null){
            if(head.data != middleNode.data){ 
                reverse(x);
                return false;
            }
            head = head.next;
            middleNode = middleNode.next;
        }
        reverse(x);
        return true;
    }

}
