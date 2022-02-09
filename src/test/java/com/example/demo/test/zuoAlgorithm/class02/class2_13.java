package com.example.demo.test.zuoAlgorithm.class02;

import java.util.Scanner;


public class class2_13 {
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
        quickSort(nums,0,n-1);
        printArray(nums);
    }

    private static void quickSort(int[] nums,int l,int r) {
        if(l>=r){
            return;
        }
        swap(nums, (int) (l+Math.random()*(r-l+1)),r);
        //将数据分层
        int[] p = partition(nums,l,r);
        quickSort(nums,l,p[0]-1);
        quickSort(nums,p[1]+1,r);
    }

    private static int[] partition(int[] nums, int l, int r) {
        int i = l;
        int large = r;
        while (i<large){
            if(nums[i]>nums[r]){
                swap(nums,i,--large);
            }else if(nums[i]<nums[r]){
                swap(nums,i++,l++);
            }else {
                ++i;
            }
        }
        swap(nums,r,large);
        return new int[]{l,large};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
