package com.example.demo.test.zuoAlgorithm.classM02;

import zuoAlgorithm2.class01.Code04_UnionFind;

import java.util.ArrayList;
import java.util.List;

public class class2_9 {
    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public static int solve(int[][] grid) {
        int rowLength = grid.length;
        int culLength = grid[0].length;
        //将所有数据存入
        List<String> list = new ArrayList<>();
        for (int row = 0; row < rowLength; row++) {
            for (int cul = 0; cul < culLength; cul++) {
                if (grid[row][cul] == 1) {
                    list.add(row + "_" + cul);
                }
            }
        }
        Code04_UnionFind.UnionFindSet unionFindSet = new Code04_UnionFind.UnionFindSet(list);
        for (int row = 0; row < rowLength; row++) {
            for (int cul = 0; cul < culLength; cul++) {
                if (grid[row][cul] == 1) {
                    //上
                    if ((cul - 1) > 0 && grid[row][cul - 1] == 1) {
                        unionFindSet.union(row + "_" + cul, row + "_" + (cul - 1));
                    }
                    //下
                    if ((cul + 1) < culLength && grid[row][cul + 1] == 1) {
                        unionFindSet.union(row + "_" + cul, row + "_" + (cul + 1));
                    }
                    //左
                    if (row - 1 > 0 && grid[row - 1][cul] == 1) {
                        unionFindSet.union(row + "_" + cul, (row - 1) + "_" + cul);
                    }
                    //右
                    if (row + 1 < rowLength && grid[row + 1][cul] == 1) {
                        unionFindSet.union(row + "_" + cul, (row + 1) + "_" + cul);
                    }
                }
            }
        }

        return unionFindSet.rankMap.size();
    }

    public static void main(String[] args) {
//       int[][] array = {{1, 1, 0, 0, 0, 1, 0},
//                        {0, 0, 0, 0, 0, 1, 0},
//                        {0, 1, 0, 1, 0, 0, 0},
//                        {0, 0, 0, 1, 1, 0, 0},
//                        {1, 0, 1, 1, 0, 0, 0},
//        };
//        System.out.println(solve(array));

        char[][] c = {{1}};
        class2_9 cla = new class2_9();
        System.out.println(cla.solve(c));
    }
    /**
     * 判断岛屿数量
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve (char[][] grid) {
        // write code here
        int count = 0;
        for(int row=0;row<grid.length;row++){
            for (int cul=0;cul<grid[0].length;cul++){
                if(grid[row][cul]==1){
                    count++;
                    diffuse(grid,row,cul);
                }
            }
        }
        return count;
    }
    public void diffuse(char[][] grid,int row,int cul){
        grid[row][cul]=2;
        if(row-1>=0 && grid[row-1][cul]==1){
            diffuse(grid,row-1,cul);
        }
        if(row+1<grid.length && grid[row+1][cul]==1){
            diffuse(grid,row+1,cul);
        }
        if(cul-1>=0 && grid[row][cul-1]==1){
            diffuse(grid,row,cul-1);
        }
        if(cul+1<grid[0].length && grid[row][cul+1]==1){
            diffuse(grid,row,cul+1);
        }
    }
}
