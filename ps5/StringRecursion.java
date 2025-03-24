package ps5;

public class StringRecursion {

    public static void printReverse(String str) {
        if (str == "" || str == null)
            return;
        if (str.length() == 1) {
            System.out.print(str); // Print the last character when recursion ends
            return;
        }
        System.out.print(str.charAt(str.length() - 1));
        printReverse(str.substring(0, str.length() - 1));
    }

    public static String trim(String str) {
        if (str == null) return null;
        if (str.equals("")) return "";

        if (str.charAt(0) == ' ') {
            return trim(str.substring(1));
        } 

        if (str.charAt(str.length() - 1) == ' '){
            return trim(str.substring(0, str.length() - 1));
        }

        return str;
    }

    public static int find(char ch, String str){
        if (str.equals("") || str == null) return -1;
        if (str.charAt(0) == ch) return 0;
        int i = find(ch, str.substring(1));
        if (i == -1) return -1; 
        return i + 1;
    }
    public static String weave(String str1, String str2){
        if (str1 == null || str2 == null) throw new IllegalArgumentException();
        if (str1.equals("")) return str2;
        if (str2.equals("")) return str1;

        String res = str1.charAt(0) + "" + str2.charAt(0);
        return res + weave(str1.substring(1), str2.substring(1)); 
        
    }

    public static void main(String[] args) {
        printReverse("imgay");
        System.out.println(); // Add this line to create a new line
        System.out.println("hi" + trim("   IM SOO      GAY                           ") + "hih");
        System.out.println("hi");
        System.out.println(find('a', "gaybi"));
        System.out.println(find('x', "gaybi"));
        System.out.println(weave("hello", "hoooooo"));
    }
}