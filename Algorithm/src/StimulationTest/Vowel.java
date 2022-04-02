package StimulationTest;

import java.util.Scanner;

//元音大写，其他小写
public class Vowel {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(char c :s.toCharArray()){
            if(c =='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                sb.append(Character.toUpperCase(c));
            }
           else if(c =='A' || c=='E' || c=='I' || c=='O' || c=='U'){
                sb.append(c);
            }
           else {
               sb.append(Character.toLowerCase(c));
            }

        }
        System.out.println(sb.toString());
    }

}
