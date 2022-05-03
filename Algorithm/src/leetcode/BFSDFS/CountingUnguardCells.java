package leetcode.BFSDFS;

import java.util.HashSet;

/**
 * 2257. 统计网格图中没有被保卫的格子数
 * 给你两个整数 m 和 n 表示一个下标从 0 开始的 m x n 网格图。同时给你两个二维整数数组 guards 和 walls ，其中 guards[i] = [rowi, coli] 且 walls[j] = [rowj, colj] ，分别表示第 i 个警卫和第 j 座墙所在的位置。
 *
 * 一个警卫能看到 4 个坐标轴方向（即东、南、西、北）的 所有 格子，除非他们被一座墙或者另外一个警卫 挡住 了视线。如果一个格子能被 至少 一个警卫看到，那么我们说这个格子被 保卫 了。
 *
 * 请你返回空格子中，有多少个格子是 没被保卫 的。
 * 示例 1：
 * 输入：m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
 * 输出：7
 * 解释：上图中，被保卫和没有被保卫的格子分别用红色和绿色表示。
 * 总共有 7 个没有被保卫的格子，所以我们返回 7 。
 */
public class CountingUnguardCells {
    private HashSet<String> set = new HashSet<>();
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] map = new int[m][n];
        for(int[] g:guards){
            int x = g[0];
            int y = g[1];
            map[x][y] = 1;
        }
        for(int[] w:walls){
            int x = w[0];
            int y = w[1];
            map[x][y] = 2;
        }
        for(int[] g:guards){
            int x = g[0];
            int y = g[1];
            dfs(m,n,map,x,y);
        }
        return m*n-set.size()-guards.length-walls.length;
    }

    public void dfs(int m, int n, int[][] map, int x, int y){
        int top = x;
        while(top>0){
            top--;
            if(map[top][y]!=1 && map[top][y]!=2){
                set.add(top+"  "+y);
            }
            else break;
        }
        int down = x;
        while(down<m-1){
            down++;
            if(map[down][y]!=1 && map[down][y]!=2){
                set.add(down+"  "+y);
            }
            else break;
        }
        int left = y;
        while(left>0){
            left--;
            if(map[x][left]!=1 && map[x][left]!=2){
                set.add(x+"  "+left);
            }
            else break;
        }
        int right = y;
        while(right<n-1){
            right++;
            if(map[x][right]!=1 && map[x][right]!=2){
                set.add(x+"  "+right);
            }
            else break;
        }

    }
}
