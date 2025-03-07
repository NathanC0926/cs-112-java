package lab5;

public class processName { // Class names should be capitalized as per Java conventions
    public static int processName1(String s) {
        int spaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        return (spaceCount == 0) ? s.length() : spaceCount + 1; // Ensure the return is outside the loop
    }
    public static int minGap(int [] arr){
        int gap = 99999;
        for (int i = 1; i<arr.length;i++){
            gap = Math.min(gap, arr[i]-arr[i-1]);
        }
        return gap;
    }

    public static void main(String[] args) {
        int[] values = {1, 3, 7, 2, 12};
        System.out.println(minGap(values));
        System.out.println(processName1("John Doe Gay"));  // Should return 1
        System.out.println(processName1("SingleName"));  // Should return length of "SingleName"
    }
}
