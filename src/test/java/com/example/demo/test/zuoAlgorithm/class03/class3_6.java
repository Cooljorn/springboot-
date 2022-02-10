package com.example.demo.test.zuoAlgorithm.class03;

import java.util.Scanner;

public class class3_6 {
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
        countSort(nums);
        printArray(nums);
    }
    public static void countSort(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int[] help=new int[max+1];
        for(int i=0;i<nums.length;i++){
            help[nums[i]]=++help[nums[i]];
        }
        int i=0;
        for(int j = 0;j<help.length;j++){
            for (int k=0;k<help[j];k++){
                nums[i++]=j;
            }
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
