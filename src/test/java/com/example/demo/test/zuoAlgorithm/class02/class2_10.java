package com.example.demo.test.zuoAlgorithm.class02;

import java.util.Scanner;

public class class2_10 {
    /*
牛牛今天带来了一排气球，气球有n个，然后每一个气球里面都包含一个数字，牛牛是一个善于思考的人,于是他就想到了一个问题，
牛牛随便给你一个值K，这个值在这些气球中不一定存在，聪明的你需要把气球中包含的数字是小于K的放到这排气球的左边，大于K的放到气球的右边，
等于K的放到这排气球的中间，最终返回一个整数数组，其中只有两个值，分别是气球中包含的数字等于K的部分的左右两个下标值,如果气球中没有K这个数字就输出-1，-1。
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] lineOne = line1.split(" ");
        int n = Integer.parseInt(lineOne[0]);
        int k = Integer.parseInt(lineOne[1]);

        String line2 = scanner.nextLine();
        String[] lineTwo = line2.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(lineTwo[i]);
        }

        prograss(nums,k);
    }

    private static void prograss(int[] nums, int k) {
        //小于k的位置
        int l = -1;
        //大于k的位置
        int r = nums.length;
        int i = 0;
        while(i<r){
            if(nums[i]<k){
                ++l;
                ++i;
            }else if(nums[i]>k){
                swap(nums,i,--r);
            }else {
                ++i;
            }
        }
        if(l==i-1){
            System.out.println(-1+" "+-1);
        }else {
            System.out.println((l+1)+ " "+ (r-1));
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
