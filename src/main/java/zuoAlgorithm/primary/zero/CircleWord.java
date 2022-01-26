package zuoAlgorithm.primary.zero;

/*
*如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。 例如：picture 和 turepic 就是属于同一种循环单词。 现在给出n个单词，需要统计这个n个单词中有多少种循环单词。
*输入包括n+1行：
第一行为单词个数n(1 ≤ n ≤ 50)
接下来的n行，每行一个单词word[i]，长度length(1 ≤ length ≤ 50)。由小写字母构成
*
*
*
* */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CircleWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入单词数：");
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> list = new LinkedList<>();
        for (int i=0;i<n;i++){
            System.out.println("请输入单词：");
            String s = scanner.nextLine();
            boolean contain = false;
            for (String strIn:list){
                if(strIn.contains(s) && s.length()*2 == strIn.length()){
                    contain=true;
                    break;
                }
            }
            if(!contain){
                list.add(s+s);
            }
        }
        System.out.println(list.size());
    }
    /* 官网答案
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<String> list = new LinkedList<>();
            W : for (int i = 0; i < n; ++i) {
                String s = scanner.next();
                for(String t : list) {
                    if(t.contains(s) && t.length() == s.length() * 2)
                        continue W;
                }
                list.add(s + s);
            }

            System.out.println(list.size());
        }
    }*/
}
