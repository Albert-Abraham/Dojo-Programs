/*
You are given two sorted singly linked lists, and your task is to merge them into a single sorted linked list. Note: The input lists l1 and l2 are sorted in ascending order. The merged list should also be sorted in ascending order. Input Format The first line contains an integer n1, the size of the first list. The second line contains n1 space-separated integers, representing the elements of the first linked list. The third line contains an integer n2, the size of the second list. The fourth line contains n2 space-separated integers, representing the elements of the second linked list.
*/

import java.util.*;

public class mergeAndSort {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Node l1 = null, l2 = null, tail_1 = null,
        tail_2 = null;

        Scanner ob = new Scanner(System.in);

        System.out.print("enter n1: ");
        int n1 = ob.nextInt();

        System.out.print("enter l1: ");

        for(int i=0;i<n1;i++){
            int data = ob.nextInt();
            Node next = new Node(data);
            if(l1 == null){
                l1 = next;
                tail_1 = next;
            }
            else{
                tail_1.next = next;
                tail_1 = next;
            }
        }

        System.out.print("enter n2: ");
        int n2 = ob.nextInt();


        System.out.print("enter l2: ");
        for (int i = 0; i < n2; i++) {
            int data = ob.nextInt();
            Node next = new Node(data);
            if (l2 == null) {
                l2 = next;
                tail_2 = next;
            } else {
                tail_2.next = next;
                tail_2 = next;
            }
        }
        Node megreHead = merge(l1, l2);
        print(megreHead);
    }
    private static Node merge(Node l1, Node l2){
        Node dummy = new Node(-1);
        Node tail = dummy;
        while(l1!=null && l2!=null){
            if(l1.data > l2.data){
                tail.next = l2;
                l2 = l2.next;
            }
            else{
                tail.next = l1;
                l1 = l1.next;
            }
            tail = tail.next;
        }

        if(l1!=null) 
            tail.next = l1;
        if (l2 != null)
            tail.next = l2;

        return dummy.next;
    }
    
    private static void print(Node head) {
        
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print(" nullptr");

    }
}
