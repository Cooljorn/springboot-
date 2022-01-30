package com.example.demo.test.zuoAlgorithm;

import java.util.Scanner;

public class class1_11 {
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
        int right = n-1;
        int left = 0;
        /*
         * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0] < arr[1]，那么arr[0]是局部最小；
            如果arr[N-1]<arr[N-2],那么arr[N-1]是局部最小；如果0<i<N-1，既有arr[i] < arr[i-1]，又有arr[i] < arr[i + 1]，那么arr[i]
            是局部最小。给定无序数组arr,已知arr中任意两个相邻的数都不相等，只需要返回arr中任意一个局部最小出现的位置即可，如果不存在这个位置就输出-1。
         * */
        while (left<=right){
            if(left==right){
                System.out.println(left);
                return;
            }
            if (nums[left] < nums[left+1]) {
                System.out.println(left);
                return;
            }
            if(nums[right] < nums[right-1]){
                System.out.println(right);
                return;
            }
            int midIndex = left+(right-left)>>2;
            if(nums[midIndex]>nums[midIndex+1]){
                left = midIndex+1;
            }else {
                right=midIndex;
            }
        }

    }
}
