package leetcode.Stimulate;

/**
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 *
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class MultiplyStrings {
    // 2ms
    public String multiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")) return "0";
        int m =num1.length();
        int n = num2.length();
        int[] arr = new int[m+n];
        for(int i = m-1; i>=0; i--){
            int x = num1.charAt(i)-'0';
            for(int j = n-1; j>=0; j--){
                int y = num2.charAt(j)-'0';
                int sum = arr[i+j+1] + x*y;
                arr[i+j+1] = sum%10;
                arr[i+j] +=sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<arr.length;i++){
            if(i==0 && arr[i]==0) continue; // 先导0去掉
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
