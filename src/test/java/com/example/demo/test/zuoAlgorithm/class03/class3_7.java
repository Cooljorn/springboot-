package com.example.demo.test.zuoAlgorithm.class03;

import java.util.Scanner;

public class class3_7 {
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
        radixSort(nums);
        printArray(nums);
    }

    private static void radixSort(int[] nums) {
        if(nums==null || nums.length<2){
            return;
        }
        //获取数字最高位数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        radixSort(nums,0,nums.length-1,res);
    }

    private static void radixSort(int[] nums, int l, int r, int digit) {
        final int radix = 10;
        int[] bucket = new int[r-l+1];
        int j=0;
        int k=0;
        for(int i=1;i<=digit;i++){
            //count[0]存当前位（i位）为0的数字有几个
            //count[1]存当前位（i位）为1的数字有几个
            int[] count = new int[radix];
            for(j=0;j<nums.length;j++){
                count[getDigit(nums[j],i)]++;
            }
            //count[j]存数组i位中<=j的数字有几个
            for(j=1;j<radix;j++){
                count[j] = count[j]+count[j-1];
            }
            //从右向左开始遍历
            for(j=r;j>=l;j--){
                k = getDigit(nums[j],i);
                bucket[count[k]-1] = nums[j];
                count[k]--;
            }
            for(j=l;j<=r;j++){
                nums[j] = bucket[j];
            }

        }
    }
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
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
