package com.example.demo.test.zuoAlgorithm.class04;

import java.util.Scanner;

public class class4_6 {
    //单向链表
    public static class ListNode {
        int val;
        class4_6.ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        int n = Integer.parseInt(line1);
        String line2 = scanner.nextLine();
        String[] lineTwo = line2.split(" ");
        int[] nums = new int[n];
        ListNode head1 = null;
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(Integer.parseInt(lineTwo[i]));
            ListNode head = head1;
            if(head == null){
                head1 = node;
            }else {
                while (head.next!=null){
                    head = head.next;
                }
                head.next = node;
            }
        }
        String line3 = scanner.nextLine();
        int m = Integer.parseInt(line3);
        String line4 = scanner.nextLine();
        String[] lineFour = line4.split(" ");
        ListNode head2 = null;
        for (int i = 0; i < m; i++) {
            ListNode node = new ListNode(Integer.parseInt(lineFour[i]));
            ListNode head = head2;
            if(head == null){
                head2 = node;
            }else {
                while (head.next!=null){
                    head = head.next;
                }
                head.next = node;
            }
        }
        ListNode node1 = head1;
        ListNode node2 = head2;
        while (head1!=null && head2!=null){
            if(head1.val== head2.val){
                System.out.print(head1.val+" ");
                head2 = head2.next;
                head1 = head1.next;
            }else if(head1.val > head2.val){
                head2 = head2.next;
            }else if(head1.val < head2.val){
                head1 = head1.next;
            }
        }


    }
}
