package com.example.demo.test.zuoAlgorithm.classM01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class class1_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = reader.readLine())!=null){
            int n = Integer.parseInt(str);
            for (int i=0;i<n;i++){
                int num = Integer.parseInt(reader.readLine());
                str = reader.readLine();
                String[] s = str.split(" ");
                HashSet<String> set = new HashSet<>();
                for(int j=0;j<s.length;j++){
                    str = s[j];
                    if(!set.contains(str)){
                        System.out.print(str+" ");
                        set.add(str);
                    }
                }
                System.out.println("");
            }
        }
    }
}
