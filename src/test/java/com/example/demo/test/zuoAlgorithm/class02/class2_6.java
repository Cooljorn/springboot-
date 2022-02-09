package com.example.demo.test.zuoAlgorithm.class02;

import java.util.Scanner;

public class class2_6 {
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
        //归并
        margerSort(nums,0,n-1);
        printArray(nums);

    }

    private static void margerSort(int[] nums, int l, int r) {
        if(l>=r){
            return;
        }
        int m = l+((r-l)>>1);
        margerSort(nums,l,m);
        margerSort(nums,m+1,r);
        marger(nums,l,m,r);
    }
    private static void marger(int[] nums, int l, int m, int r) {
        int[] help = new int[r-l+1];
        int p1=l;
        int p2=m+1;
        int i=0;
        while(p1<=m && p2<=r){
            if(nums[p1]>nums[p2]){
                help[i++] = nums[p2++];
            }else{
                help[i++] = nums[p1++];
            }
        }
        while(p1<=m){
            help[i++] = nums[p1++];
        }
        while (p2<=r){
            help[i++] = nums[p2++];
        }
        // 将值附回原数组
        for(i=0;i<r-l+1;i++){
            nums[l+i] = help[i];
        }
    }
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
