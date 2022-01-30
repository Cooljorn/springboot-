package com.example.demo.test.zuoAlgorithm;

import java.util.Scanner;

public class class1_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] lineOne = line1.split(" ");
        int n = Integer.parseInt(lineOne[0]);
        int findKey = Integer.parseInt(lineOne[1]);
        String line2 = scanner.nextLine();
        String[] lineTwo = line2.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(lineTwo[i]);
        }
        int right = n-1;
        int left = 0;
        /*给你一个n代表有一个长度为n的有序数组，然后给你一个k，你需要判断这个k是否在数组里面，
            如果存在就返回这个数从左往右第一次出现位置的下标，如果不存在输出-1*/
        /*while (left<=right){
            if(nums[left]>findKey || nums[right]<findKey){
                System.out.println(-1);
                return ;
            }
            int midIndex = left+((right-left)>>1);
            if(nums[midIndex]<findKey){
                left = midIndex+1;
            }else if(nums[midIndex]>findKey) {
                right = midIndex-1;
            }else if(nums[midIndex]==findKey){
                if(midIndex==left || (midIndex>left &&  nums[midIndex-1]!=findKey)){
                    System.out.println(midIndex);
                    return;
                } else {
                    right = midIndex-1;
                }
            }
        }*/
/*
* 你需要输入一个n，一个数k，然后输入一个长度为n个大小的数组arr，然后你需要在arr上找满足>=K的最左位置，并且输出这个位置，如果不存在这个位置就输出-1。
* */
        while (left<=right){
            if(nums[right]<findKey){
                System.out.println(-1);
                return ;
            }
            if(nums[left]>=findKey){
                System.out.println(left);
                return;
            }
            int midIndex = left+((right-left)>>1);
            if(nums[midIndex]<findKey){
                left = midIndex+1;
            }else if(nums[midIndex]>=findKey) {
                if(nums[midIndex-1]<findKey){
                    System.out.println(midIndex);
                    return;
                }else{
                    right = midIndex-1;
                }
            }
        }

    }
}
