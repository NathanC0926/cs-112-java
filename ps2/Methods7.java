package ps2;

public class Methods7 {

    public static void printDiag(String s) {
        for (int i = 0; i < s.length(); i++) {
            helperPrintDiag(i);
            System.out.println(s.charAt(i));
        }
    }

    public static void helperPrintDiag(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print(" ");
        }
    }

    public static String lastN(String s, int n) {
        String res = "";
        if (n > s.length()) {
            res = s;
        } else {
            res = s.substring(s.length() - n);
        }
        return res;
    }

    public static String remSub(String x, String y) {
        int end = x.indexOf(y);
        if (end == -1) {
            return x;
        }
        int start = end + y.length();
        return x.substring(0, end) + x.substring(start);
    }

    public static String interleave(String s1, String s2){
        int n = (s1.length() < s2.length()) ? s1.length() : s2.length();
        String res = "";
        for (int i = 0; i < n; i++){
            res += s1.charAt(i);
            res += s2.charAt(i);
        }
        if (s1.length() == s2.length()){
            return res;
        }
        else if (s1.length() > s2.length()){
            return res + s1.substring(n);
        }
        else{
            return res + s2.substring(n);
        }
    }
    public static void main(String[] args) {
        printDiag("method");
        System.out.println(lastN("programming", 5));
        System.out.println(remSub("variable", "var"));
        System.out.println(interleave("hello", "world"));
    }

}
