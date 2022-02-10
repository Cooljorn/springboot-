package com.example.demo.test.zuoAlgorithm.class02;

import java.util.Scanner;

public class class2_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line1 = scanner.next();
            char[] letter = new char[line1.length()];
            int letterLength = 0;
            for (int i = 0; i < line1.length(); i++) {
                if (('a' <= line1.charAt(i) && line1.charAt(i) <= 'z') || ('A' <= line1.charAt(i) && line1.charAt(i) <= 'Z')) {
                    letter[letterLength++] = line1.charAt(i);
                }
            }
            //quickSortLetter(letter,0,letterLength-1);
            sort(letter, 0, letterLength - 1);
            int outIndex = 0;
            for (int i = 0; i < line1.length(); i++) {
                if (('a' <= line1.charAt(i) && line1.charAt(i) <= 'z') || ('A' <= line1.charAt(i) && line1.charAt(i) <= 'Z')) {
                    System.out.print(letter[outIndex++]);
                } else {
                    System.out.print(line1.charAt(i));
                }
            }
            System.out.println("");
        }
    }
    //归并排序
    private static void sort(char[] nums, int l, int r) {
        if(l>=r){
            return;
        }
        int mid = l+((r-l)>>1);
        sort(nums,l,mid);
        sort(nums,mid+1,r);
        marge(nums,l,mid,r);
    }

    private static void marge(char[] nums, int l, int mid, int r) {
        char[] help = new char[r-l+1];
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while (p1<=mid && p2<=r){
            if(toLowerCase(nums[p1])>toLowerCase(nums[p2])){
                help[i++] = nums[p2++];
            }else {
                help[i++] = nums[p1++];
            }
        }
        while (p1<=mid){
            help[i++] = nums[p1++];
        }
        while (p2<=r){
            help[i++] = nums[p2++];
        }
        for(i=0;i<help.length;i++){
            nums[l+i] = help[i];
        }
    }

    private static void quickSortLetter(char[] nums, int l, int r) {
        if(l>=r){
            return;
        }
//        swap(nums, (int) (l+Math.random()*(r-l+1)),r);
        int[] p = partition(nums,l,r);
        quickSortLetter(nums,l,p[0]-1);
        quickSortLetter(nums,p[1]+1,r);
    }
    private static int[] partition(char[] nums, int l, int r) {
        int large = r;
        int i = l;
        while (i<large){
            if (toLowerCase(nums[i]) > toLowerCase(nums[r])) {
                //先后顺序会打乱
                swap(nums, i, --large);
            } else if (toLowerCase(nums[i]) < toLowerCase(nums[r])) {
                //先后顺序会打乱
                swap(nums, i++, l++);
            } else {
                ++i;
            }
        }
//        swap(nums,large,r);
        //将大于的值进行移位
        int p1 = large;
        int p2 = r;
        while (p1<p2){
            swap(nums,p1++,p2--);
        }
        return new int[]{l,large};
    }
    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //获取字符对应小写字符的大小
    public static int toLowerCase(char a) {
        if('A'<=a && a<='Z'){
            return a+ ('a'-'A');
        }else {
            return a;
        }
    }
}
