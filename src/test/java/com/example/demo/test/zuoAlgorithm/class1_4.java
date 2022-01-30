package com.example.demo.test.zuoAlgorithm;

import java.util.Scanner;
public class class1_4 {
    /*给你一个n代表有n个数字，给出这n个数字，然后你需要使用冒泡排序将这些数字从小到大排好*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String numbers = scanner.nextLine();
        String[] s = numbers.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        //冒泡
//        for (int i = n - 1; i > 0; i--) {
//            for (int j = i; j > 0; j--) {
//                if (nums[j] < nums[j - 1]) {
//                    swap(nums, j, j - 1);
//                }
//            }
//        }
        //选择
//        for (int i = 0; i <n-1; ++i) {
//            int index = i;
//            for (int j = i+1; j <n; j++) {
//                index= nums[index]>nums[j] ? j : index;
//            }
//            swap(nums, i, index);
//        }
        //插入
        for (int i=0;i<n;++i){
            for(int j=i;j>0&&nums[j]<nums[j-1];--j){
                swap(nums, j, j-1);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void swap(int[] s, int i, int j) {
        if(s[i]==s[j]) return;
        s[i] = s[i] ^ s[j];
        s[j] = s[i] ^ s[j];
        s[i] = s[j] ^ s[i];
    }
}
