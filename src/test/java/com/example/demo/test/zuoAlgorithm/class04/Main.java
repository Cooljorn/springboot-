package com.example.demo.test.zuoAlgorithm.class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line;
        int n = nextInt();
        Node head1 = init(n);
        int m = nextInt();
        Node head2 = init(m);
        StringBuilder sb = new StringBuilder();
        Node cur1 = head1.next;
        Node cur2 = head2.next;
        while (cur1 != null && cur2 != null) {
            if (cur1.value > cur2.value) {
                cur2 = cur2.next;
            } else if (cur1.value < cur2.value) {
                cur1 = cur1.next;
            } else {
                sb.append(cur1.value).append(" ");
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        System.out.println(sb.toString().trim());

    }

    //单链表结构
    public static class Node {
        public Node next = null;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    //建立一个单链表
    public static Node init(int length) {
        Node head = new Node(-1);
        Node cur = head;
        for (int i = 0; i < length; i++) {
            Node node = new Node(nextInt());
            cur.next = node;
            cur = node;//移动指针
        }
        return head;
    }

    //输出链表的值
    /*public static void soutLinkedLis(Node head) {
        Node cur = head.next;
        while(cur != null) {
            System.out.print(cur.value+" ");
            cur = cur.next;
        }
        System.out.println();
    }*/
    public static int nextInt() {
        try {
            st.nextToken();
            return (int) (st.nval);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.MIN_VALUE;
    }
}
