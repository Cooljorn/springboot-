package com.example.demo.test.zuoAlgorithm.class02;

public class XiaoHe {
    public static void main(String[] args) {
        int []arr = new int[5];
        process(arr,0,arr.length);
    }

    private static void process(int[] arr, int l, int r) {
        if(l==r){
            return;
        }
        int m = l+(r-l)>>1;
        process(arr,l,m);
        process(arr,m+1,r);
        marge(arr,l,m,r);
    }

    private static void marge(int[] arr, int l, int m, int r) {
        int[] help = new int[r-l+1];
        int i= 0;
        int p1 = l;
        int p2 = m+1;
        while(p1 <=m && p2<=r){
            help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2];
        }
        while(p1<=m){
            help[i++] = arr[p1++];
        }
        while(p2<=r){
            help[i++] = arr[p2++];
        }
        for(i=0;i<help.length;i++){
            arr[l+i] = help[i];
        }
    }
}
