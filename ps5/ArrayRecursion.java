public class ArrayRecursion {
    public static boolean search(int item, int[] arr, int start) {
        // Always check for null references first!
        if (arr == null) {
           throw new IllegalArgumentException();
        }
        // base case: if we reached an end, it is not found
        if (start == arr.length) return false;
        if (arr[start] == item) return true;
        else return search(item, arr, start+1);
     }
     public static String reverseArrayToString(String[] arr, int index){
        if (arr == null) return "";

        int n = arr.length - 1;
        if (n == 0) return "[" + arr[0] + "]";
        
        if (index == n) {
            return arr[0] + "]";
        }
        if (index == 0) {
            return "[" + arr[n - index] + "," + reverseArrayToString(arr,index+1);
        }
        return arr[n - index] + "," + reverseArrayToString(arr,index+1);
        
     }
     public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7};
        System.out.println(search(0, A, 0));
        System.out.println(search(7, A, 0));
        String a[] = { "abc"};
        System.out.println(reverseArrayToString(a, 0));
     }
}
