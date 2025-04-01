public class GenerateSums {
    public static String generateSums(int n){
        if (n == 0) return "";
        if (n == 1) return "1";
        String res = "";
        int prefixSum = 0;
        String prefixString = "1";
        for (int i = 1; i <= n; i++){
            prefixSum += i;
            if (i != 1) prefixString = prefixString + " + " + i;
            if (i == 1) res = res + prefixSum + '\n';
            else if (i == n) res = res + prefixString + " = " + prefixSum;
            else res = res + prefixString + " = " + prefixSum + '\n';
        
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("n = 1:\n" + generateSums(1));
        System.out.println("\nn = 4:\n" + generateSums(4));
        System.out.println("\nn = 6:\n" + generateSums(6));
        
    }
}
