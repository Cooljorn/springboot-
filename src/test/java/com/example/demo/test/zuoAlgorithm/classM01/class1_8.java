package com.example.demo.test.zuoAlgorithm.classM01;

import com.example.demo.test.zuoAlgorithm.class04.class4_6;

import java.util.*;

public class class1_8 {
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public static int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        int i=0;
        for(;i<numbers.length;i++){
            if(!map.containsKey(numbers[i])){
                map.put(numbers[i], new ArrayList<Integer>());
            }
            map.get(numbers[i]).add(i);
        }
        for (i=0;i<numbers.length;i++){
            if(target>=numbers[i]){
                int sub = target-numbers[i];
                if(map.containsKey(sub)){
                    List<Integer> value = map.get(sub);
                    for (int subIndex: value) {
                        if (i < subIndex) {
                            return new int[]{i+1, subIndex+1};
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,4,3,0};
        int[] ints = twoSum(nums, 0);
        for (int i=0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }
}
