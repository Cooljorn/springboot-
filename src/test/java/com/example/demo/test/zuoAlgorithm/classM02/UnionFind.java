package com.example.demo.test.zuoAlgorithm.classM02;

import com.example.demo.test.zuoAlgorithm.Element;
import zuoAlgorithm2.class01.Code04_UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集
 * 主要用于解决一些元素分组的问题。它管理一系列不相交的集合，并支持两种操作：
 *
 * 合并（Union）：把两个不相交的集合合并为一个集合。
 * 查询（Find）：查询两个元素是否在同一个集合中。
 */
public class UnionFind<V> {
    public HashMap<V, Element<V>> elementMap;
    public HashMap<Element<V>,Element<V>> fatherMap;
    public HashMap<Element<V>,Integer> rankMap;
    public UnionFind(List<V> list){
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        rankMap = new HashMap<>();
        for(V vlaue:list){
            Element<V> element = new Element<V>(vlaue);
            elementMap.put(vlaue,element);
            fatherMap.put(element,element);
            rankMap.put(element,1);
        }
    }
    private Element<V> findHead(Element<V> element){
        Stack<Element<V>> path = new Stack<>();
        while (element != fatherMap.get(element)){
            path.push(element);
            element = fatherMap.get(element);
        }
        while (!path.isEmpty()){
            fatherMap.put(path.pop(),element);
        }
        return element;
    }
    public boolean isSameSet(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }
        return false;
    }
    public void union(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> aF = findHead(elementMap.get(a));
            Element<V> bF = findHead(elementMap.get(b));
            if (aF != bF) {
                Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                Element<V> small = big == aF ? bF : aF;
                fatherMap.put(small, big);
                rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                rankMap.remove(small);
            }
        }
    }

}
