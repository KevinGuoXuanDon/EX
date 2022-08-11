package leetcode.BFSDFS;

/**
 * 你被给定一个m × n的二维网格 rooms ，网格中有以下三种可能的初始化值：
 *
 * -1表示墙或是障碍物
 * 0表示一扇门
 * INF无限表示一个空的房间。然后，我们用231 - 1 = 2147483647代表INF。你可以认为通往门的距离总是小于2147483647的。
 * 你要给每个空房间位上填上该房间到最近门的距离 ，如果无法到达门，则填INF即可。
 *
 *
 * 示例 1：
 *
 *
 * 输入：rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * 输出：[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 
 */
public class WallsAndGates {

    /**
     * 先提供一种超时的DFS写法，每次从门开始向四周搜索，门越多全图搜索次数越多，此时复杂度为O(k*m*n)
     * k为门的数量。
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        for(int i=0; i< rooms.length; i++){
            for(int j = 0; j< rooms[0].length; j++){
                if(rooms[i][j]==0){
                    distanceToDoor(i,j,rooms,0);
                    System.out.println(i+" "+j);
                }
            }
        }
    }
    public void distanceToDoor(int x, int y, int[][] rooms, int dis){
        if(x<0 || x >= rooms.length || y<0 || y>= rooms[0].length){
            return;
        }
        else if(dis!=0 && rooms[x][y]< dis){
            return;
        }
        rooms[x][y] = dis;
        distanceToDoor(x+1,y,rooms,dis+1);
        distanceToDoor(x-1,y,rooms,dis+1);
        distanceToDoor(x,y+1,rooms,dis+1);
        distanceToDoor(x,y-1,rooms,dis+1);

    }
}
