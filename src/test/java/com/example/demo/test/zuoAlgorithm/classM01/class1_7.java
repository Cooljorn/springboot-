package com.example.demo.test.zuoAlgorithm.classM01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class class1_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> map = new TreeMap<>();
        String str = null;
        while ((str = bufferedReader.readLine())!=null){
            int n = Integer.parseInt(str);
            for (int i=0;i<n;i++){
                str = bufferedReader.readLine();
                String[] splitStr = str.split(" ");
                int key = Integer.parseInt(splitStr[0]);
                int value = Integer.parseInt(splitStr[1]);
                if(map.containsKey(key)){
                    value += map.get(key);
                }
                map.put(key,value);
            }
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                int key = iterator.next();
                System.out.println(key+" "+map.get(key));
            }
        }
    }
}
