package midterm2;

public class Mid2 {
    public static double sumReciprocals(int n){
        if (n == 1) return 1.0;
        return (1.0/n) + sumReciprocals(n-1);
    }
    public static String removePadding(String s){
        //if (s.equals(null) || s.isEmpty()) return "";
        String res = s;
        if (s.charAt(0) == ' ') 
            res = removePadding(res.substring(1));
        if (s.charAt(s.length()-1) == ' ') 
            res = removePadding(res.substring(0,res.length()-1));
        return res;

        public static Node everyOther(Node head){
            if (head == null) return null;
            if (head.next != null)
                head.next = everyOther(head.next.next);
                return head;
            return head;
        
        }
    }
    public static void main(String[] args) {
        System.out.println(sumReciprocals(2));
        System.out.print(removePadding("    helow world               "));
        System.out.println("gay");
    }
}
