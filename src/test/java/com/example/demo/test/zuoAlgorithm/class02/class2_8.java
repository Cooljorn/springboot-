package com.example.demo.test.zuoAlgorithm.class02;

import java.util.Scanner;


public class class2_8 {
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
        heapSort(nums);
        printArray(nums);
    }

    private static void heapSort(int[] nums) {
        int heapSize = nums.length;
        //将数组调整为大根堆
        int i=heapSize-1;
        while(i>-1) {
            heapify(nums,i--,heapSize);
        }
        //将最大的数字移至数组最后位
        swap(nums, 0, --heapSize);
        while (heapSize > 0) { // O(N)
            heapify(nums, 0, heapSize); // O(logN)
            swap(nums, 0, --heapSize); // O(1)
        }
    }

    /**
     * 将i位置调整为大根
     * @param nums
     * @param i
     * @param heapSize
     */
    private static void heapify(int[] nums, int i, int heapSize) {
        //左子树
        int l = i*2+1;

        while(l<heapSize) {
            //比较当前位置和左右子树那个更大
            int largeIndex = l+1<heapSize && nums[l]<nums[l+1]?l+1:l;
            largeIndex = nums[i]>nums[largeIndex]?i:largeIndex;
            if(largeIndex == i){
                break;
            }
            swap(nums,largeIndex,i);
            i = largeIndex;
            l = i*2+1;
        }
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
