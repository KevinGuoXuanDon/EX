package leetcode.Array.Prefix;

/**
 * 一个二维数组中，如果对于行i来说，如果i之前行数字的和等于 i之后行数字和，则行i是平衡行
 * 同理，列j会是平衡列，那么一个平衡点就是(i,j)
 * 找出二维数组平衡点，返回i+j
 */
public class FindingEquilibriumPoint {
    public int solution(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[] prefixRow = new int[n];
        int[] prefixCol = new int[m];
        for(int i=0;i<n;i++){
            prefixCol[0] += A[i][0];
        }
        for(int i=0;i<m;i++){
            prefixRow[0] += A[0][i];
        }
        for(int i=1; i<n; i++){
            for(int j = 0; j<m; j++){
                prefixRow[i] += A[i][j];
            }
            prefixRow[i] += prefixRow[i-1];
        }
        for(int i=1; i<m; i++){
            for(int j = 0; j<n; j++){
                prefixCol[i] += A[j][i];
            }
            prefixCol[i] += prefixCol[i-1];
        }
        // 2 7 5
        // 3 1 1
        // 2 1 -7
        // 0 1 2
        // 1 6 8
        int x = getBalancePoint(prefixRow);
        int y = getBalancePoint(prefixCol);
        return x + y;
    }
    public int getBalancePoint(int[] prefixRow){
        int n = prefixRow.length;
        int x = 0;
        for(int i=0; i<n;i++){
            if(i==0){
                if(prefixRow[n-1]-prefixRow[0] == 0){
                    x = i;
                    break;
                }
            }
            else if(i==n-1){
                if(prefixRow[n-2]==0){
                    x = i;
                    break;
                }
            }
            else {
                if(prefixRow[n-1] - prefixRow[i] == prefixRow[i-1]){
                    x = i;
                    break;
                }
            }
        }
        return x;
    }
}
