package Compete;

import java.util.HashSet;

public class CountPointInCircle {
    HashSet<String> res = new HashSet<>();
    public static void main(String[] args) {
        CountPointInCircle count = new CountPointInCircle();
        int[][] arr = new int[][]{
                {10,9,8},{5,9,5}};
        count.countLatticePoints(arr);
        System.out.println(count.res.size());
    }

    // 差分数组 4ms

    /**
     * 枚举圆中线段，把线段视作一段区间，
     * 利用差分数组进行区间修改l-r只需d[l]+v和d[r+1]-v，不用枚举记录点在所有圆中出现次数。
     * 枚举点验证是否包含在任意圆中，因为枚举点所以不会重复计算点的数目
     * 枚举外切正方形的点改为枚举圆中线段，可以观察到由圆心到一端的线段从2*半径的长度逐渐缩短到1，遍历圆心到一端，若线段端点不在圆中则缩短线段-1，所有圆中线段上所有的点即为圆中所有点。
     *

     * @param circles
     * @return
     */
    public int countLatticePointsByDiff(int[][] circles) {
        int n=circles.length;
        int count=0;
        int v=0;
        int[][] diff=new int[201][202];
        for(int i=0;i<n;i++){
            int cx=circles[i][0];
            int cy=circles[i][1];
            int r=circles[i][2];
            int len=r;
            for(int up=0;up<=r;up++){
                // 保证在圆内
                while(len*len+up*up>r*r){
                    len--;
                }
                // 从中心到两端，一行一行的枚举圆内的线段
                diff[cy+up][cx-len]+=1;
                diff[cy+up][cx+len+1]-=1;
                diff[cy-up][cx-len]+=1;
                diff[cy-up][cx+len+1]-=1;
            }
        }
        for(int y=0;y<=200;y++){
            for(int x=0;x<=200;x++){
                v+=diff[y][x];
                if(v>0){
                    count++;
                }
            }
            v=0;
        }
        return count;
    }
    


    // 画布思想，找到左上方，左下方，右上方，右下方四个点，在这个画布中寻找多少个点在圆上 133ms
    public int countLatticPointsSolved(int[][] circles){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;
        for(int[] arr:circles) {
            int x = arr[0];
            int y = arr[1];
            int r = arr[2];
            minX = Math.min(x-r,minX);
            maxX = Math.max(x+r,maxX);
            minY = Math.min(y-r,minY);
            maxY = Math.max(y+r,maxY);
        }
        int count = 0;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                for(int[] arr:circles) {
                    int x = arr[0];
                    int y = arr[1];
                    int r = arr[2];
                    if(inCircle(x,y,r,i,j)){
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    // 思路：每个圆都搜索一次内部存在的点，死于最后3个测试用例，包含大量重复计算（被针对了），解决思路差分数组
    // [[100,100,100],[100,100,100],[100,100,100],[100,100,100],[100,100,100],
    // [100,100,100],[100,100,100],[100,100,100],[100,100,100],[100,100,100],
    // [100,100,100],[100,100,100],[100,100,100],[100,100,100],[100,100,100],
    // [100,100,100],[100,100,100],[100,100,100],[100,100,100],[100,100,100],
    public int countLatticePoints(int[][] circles) {
        for(int[] arr:circles){
            HashSet<String> set = new HashSet<>();
            int x = arr[0];
            int y = arr[1];
            int r = arr[2];
            findPoint(set,x,y,r,x,y);
            res.addAll(set);
        }
        return res.size();
    }
    public void findPoint(HashSet<String> set, int x, int y, int r, int tx, int ty){
        if(set.contains(tx+" "+ty) || !inCircle(x,y,r,tx,ty)){
            return;
        }
        set.add(tx+" "+ty);
        findPoint(set,x,y,r,tx-1,ty);
        findPoint(set,x,y,r,tx+1,ty);
        findPoint(set,x,y,r,tx,ty-1);
        findPoint(set,x,y,r,tx,ty+1);
    }
    public boolean inCircle(int x, int y, int r, int tx, int ty){
        double distance = Math.sqrt(Math.pow(tx-x,2)+Math.pow(ty-y,2));
        if(distance>r){
            return false;
        }
        return true;
    }
}
