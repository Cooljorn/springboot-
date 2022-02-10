package zuoAlgorithm.class03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class class3_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] nums = new int[n][2];
        for (int i=0;i<n;i++){
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            nums[i][0] = Integer.parseInt(s1[0]);
            nums[i][1] = Integer.parseInt(s1[1]);
        }
        List<String> result = getMaxPoint(nums);
        result.stream().forEach(System.out::println);
    }

    private static List<String> getMaxPoint(int[][] nums) {
        List<String> result = new ArrayList<>();
        //双层循环
        for(int i=0;i<nums.length;i++){
            boolean y = true;
            for(int j=0;j<nums.length;j++){
                if(nums[j][0]>nums[i][0] && nums[j][1]>nums[i][1]){
                    y = false;
                    break;
                }
            }
            if(y){
                result.add(nums[i][0] +" "+nums[i][1]);
            }
        }
        //排序
        return result.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ");
                String[] s2 = o2.split(" ");
                return Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);
            }
        }).collect(Collectors.toList());
    }
}
