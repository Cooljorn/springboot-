package com.example.demo.test.zuoAlgorithm.class02;

import com.example.demo.test.zuoAlgorithm.Util;

public class SortArr {
    public static void main(String[] args) {
        int[] arr = {13,11};
        int num = 8;
//        progress(arr,num);
        progress2(arr,num);
        Util.printArray(arr);
    }
    //给定一个数组arr，和一个数num，请把小于等于num的数放在数 组的左边，大于num的 数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)
    private static void progress(int[] arr, int num) {
        int l = 0;
        int r = arr.length-1;
        while (l<r){
            if(arr[l]>num){
                Util.swap(arr,l,r);
                --r;
            }else {
                ++l;
            }
        }
    }
    //给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，等于num的数放 在数组的中间，大于num的数放在数组的 右边。要求额外空间复杂度O(1)，时间复杂度 O(N)
    private static void progress2(int[] arr, int num) {
        int l = -1;//小于范围
        int r = arr.length;//大于范围
        int i = 0;//当前位置
        while (i<r){
            if(arr[i]>num){
                Util.swap(arr,i,--r);
            }else if(arr[i]<num){
                Util.swap(arr,i,++l);
                ++i;
            }else {
                ++i;
            }
        }
    }

}
