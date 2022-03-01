package MicroSoft;

public class NumIslands {

    //如果能够改变传参，使用flag做标记 4ms.
    //如果能够改变传参，直接把'1'变成0，2ms
    boolean[][] flag;
    public int numIslands(char[][] grid){
        flag = new boolean[grid.length][grid[0].length];
        int count =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!flag[i][j] && grid[i][j]=='1'){
                    count++;
                    recur(grid,i,j);
                }
            }
        }
        return count;
    }
    public void recur(char[][] grid, int i, int j){
        if(grid[i][j]=='0' || flag[i][j]) return;
        else{
            flag[i][j] =true;
            if(i+1 <= grid.length-1) recur(grid,i+1,j);
            if(i-1 >=0) recur(grid,i-1,j);
            if(j+1 <= grid[0].length-1) recur(grid,i,j+1);
            if(j-1 >=0) recur(grid,i,j-1);
        }
    }
}
