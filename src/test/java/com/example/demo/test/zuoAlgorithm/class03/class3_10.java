package com.example.demo.test.zuoAlgorithm.class03;

import java.util.Scanner;

public class class3_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            String s = scanner.nextLine();
            nums[i] = Integer.parseInt(s.substring(s.length()-6,s.length()));
        }
        //快排
        quickSort(nums,0,n-1);
        for (int i=0;i<n;i++){
            System.out.println(nums[i]);
        }
    }
    private static void quickSort(int[] nums,int l,int r) {
        if(l>=r){
            return;
        }
        swap(nums,(int) (l+Math.random()*(r-l+1)),r);
        int p[] = partition(nums,l,r);
        quickSort(nums,l,p[0]-1);
        quickSort(nums,p[1]+1,r);
    }

    private static int[] partition(int[] nums, int l, int r) {
        int i=l;
        int j=r;
        while(i<j){
            if(nums[i]>nums[r]){
                swap(nums,i,--j);
            }else if(nums[i]<nums[r]){
                swap(nums,i++,l++);
            }else {
                i++;
            }
        }
        swap(nums,j,r);
        return new int[]{l,j};
    }

    private static void swap(int[] nums, int l, int r) {
        int tem = nums[l];
        nums[l] = nums[r];
        nums[r] = tem;
    }
}
