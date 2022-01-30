package com.example.demo.test.zuoAlgorithm;

import java.util.Scanner;

public class class1_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        int n = Integer.parseInt(line1);
        String line2 = scanner.nextLine();
        String[] lineTwo = line2.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(lineTwo[i]);
        }
        int max = findValue(nums,0,n-1);
        System.out.println(max);
    }
    public static int findValue(int[] nums,int left,int right){
        if(left == right){
            return nums[left];
        }
        int mid = left+((right-left)>>1);
        int rValue = findValue(nums,left,mid);
        int lValue = findValue(nums,mid+1,right);
        return Math.max(lValue,rValue);
    }
}
