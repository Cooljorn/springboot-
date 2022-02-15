package com.example.demo.test.zuoAlgorithm.class01;

import java.util.Scanner;

public class class1_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        int n = Integer.parseInt(line1);
        String line2 = scanner.nextLine();
        String[] lineTwo = line2.split(" ");
        /*
        * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数
        * */
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            result ^= Integer.parseInt(lineTwo[i]);
//        }
//        System.out.println(result);

        /*
        * 给定一个数字arr，其中只有两个数字出现了奇数次，其它数字都出现了偶数次，按照从小到大顺序输出这两个数。
        * */

        int result1 = 0;
        int result2 = 0;
        int[] nums = new int[n];
        int midResult = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(lineTwo[i]);
            midResult ^= nums[i];
        }
        int firstOne = midResult & (~midResult+1);//两个数最右侧不相同的位置
        for (int i = 0; i < n; i++) {
            if((firstOne & nums[i])==0){
                result1 ^=nums[i];
            }
        }
        result2 = midResult^result1;
        if(result1>result2){
            System.out.print(result2 + " ");
            System.out.println(result1);
        }else {
            System.out.print(result1 +" ");
            System.out.println(result2);
        }
    }
}
