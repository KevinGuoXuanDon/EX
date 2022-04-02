package StimulationTest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
public class Words {
    //四舍五入保留两位小数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        double count = strings.length;
        double len = s.replace(" ","").length();
        double ans = len/count;
        // 1. 两种四舍五入的方式
            DecimalFormat df = new DecimalFormat("#.00");
            String format = df.format(ans);
        // 2.
        BigDecimal bg = new BigDecimal(ans);
        System.out.println(bg.setScale(2,RoundingMode.HALF_UP));
    }
}

