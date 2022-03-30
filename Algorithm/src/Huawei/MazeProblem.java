package Huawei;
import java.util.*;
public class MazeProblem{
    static LinkedList<LinkedList<String>> path = new LinkedList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        LinkedList<String> list = new LinkedList<>();
        dps(matrix,0,0,n,m,list);
        LinkedList<String> res = null;
        int min = Integer.MAX_VALUE;
        for(LinkedList<String> curList:path){
            if(curList.size()<min){
                res = curList;
                min = curList.size();
            }
        }
        for(String s:res){
            System.out.println(s);
        }
    }
    public static void dps(int[][] matrix, int i, int j, int n, int m, LinkedList<String> list){
        matrix[i][j]=1;
        String str = "("+i+","+j+")";
        list.add(str);
        if(i==(n-1) && j==(m-1)){
            path.add(new LinkedList<>(list));
            return;
        }
        if(i+1<n && matrix[i+1][j]==0){
            dps(matrix,i+1,j,n,m,list);
        }
        if(i-1>=0 && matrix[i-1][j]==0){
            dps(matrix,i-1,j,n,m,list);
        }
        if(j+1<m && matrix[i][j+1]==0){
            dps(matrix,i,j+1,n,m,list);
        }
        if(j-1>=0 && matrix[i][j-1]==0){
            dps(matrix,i,j-1,n,m,list);
        }
        matrix[i][j]=0;
        list.removeLast();
    }
}
