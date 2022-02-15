package day26String;

public class IsNumber20 {
    public boolean isNumber(String s){
        s = s.trim();
        s = s.replaceAll("[^+\\-eE.0-9]","a");
        try {
            double a = Double.valueOf(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
