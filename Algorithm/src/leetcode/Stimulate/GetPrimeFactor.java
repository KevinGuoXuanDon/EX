package leetcode.Stimulate;

import java.util.Scanner;

public class GetPrimeFactor {
    public String getPrimeFactor(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(x+"=");
        int index= 2;
        while(index <= x){
            if(index==x){
                sb.append(index);
                break;
            }
            else if(x%index==0){
                sb.append(index + "*");
                x/=index;
            }
            else{
                index++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GetPrimeFactor g = new GetPrimeFactor();
        System.out.println(g.getPrimeFactor());
    }
}
