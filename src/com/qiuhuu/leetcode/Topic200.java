package com.qiuhuu.leetcode;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 * 输入:
 * [
 *  ['1','1','1','1','0'],
 *  ['1','1','0','1','0'],
 *  ['1','1','0','0','0'],
 *  ['0','0','0','0','0']
 * ]
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * [
 *  ['1','1','0','0','0'],
 *  ['1','1','0','0','0'],
 *  ['0','0','1','0','0'],
 *  ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * @author : qiuhuu
 * @date : 2020-07-21 10:28
 */
public class Topic200 {
    private static char[][] g;

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        g = grid;
        //以dfs算法写
        int i = new Topic200().numIslands(grid);
        System.out.println("岛屿数量："+i);
    }

    public int numIslands(char[][] grid) {
        //返回岛屿数
        int island = 0;
        //遍历二维数组
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //发现岛屿，再去扩散搜索四周岛屿
                if (grid[i][j] == '1'){
                    sink(i, j);
                    island ++;
                }
            }
        }
        return island;
    }

    /**
     * 发现相邻岛屿，下沉它们
     * @param i
     * @param j
     * @return 发现一座岛屿 返回 1
     */
    public int sink(int i,int j){
        //判断数组越界
        if (i < 0 || i >= g.length || j < 0 || j >= g[i].length || g[i][j]=='0'){
            return 0;
        }
        //发现岛屿并下沉
        g[i][j] = '0';
        //搜索当前岛屿上方，有没有岛屿
        sink(i - 1 , j);
        //右方
        sink(i ,j + 1);
        //下方
        sink(i + 1,j);
        //左方
        sink(i ,j - 1);
        return 1;
    }
}
