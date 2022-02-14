package com.example.demo.test.zuoAlgorithm.class04;

public class class4_5 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode previous = null;
        while(head!=null){
            ListNode next2 = head.next;
            head.next = previous;
            previous = head;
            head = next2;
        }
        return previous;
    }
}
