public class ArrayRecursion {

    public static boolean search(Object item, Object[] arr, int start) {
        // Always check for null references first!
        if (arr == null) {
           throw new IllegalArgumentException();
        }
        // base case: if we reached an end, it is not found
        if (start == arr.length) return false;
        if (arr[start].equals(item)) return true;
        else return search(item, arr, start+1);
     }

     public static String reverseArrayToString(Object[] arr, int index) {
      // If a null array or an empty array is passed, return an empty string.
      if (arr == null || arr.length == 0) return "";
      int n = arr.length;
      // Base case: if we are at the last element in reverse order.
      if (index == n - 1) {
          // If there's only one element, wrap it with brackets.
          if (index == 0) {
              return "[" + arr[n - 1].toString() + "]";
          } else {
              // For recursive calls, simply return the last element (which is the first element of the array).
              return arr[n - 1 - index].toString();
          }
      }
      // Get the current element (in reverse order).
      String element = arr[n - 1 - index].toString();
      // Recursively build the rest of the string.
      String rest = reverseArrayToString(arr, index + 1);
      // For the top-level call, add the opening and closing brackets.
      if (index == 0) {
          return "[" + element + ", " + rest + "]";
      } else {
          return element + ", " + rest;
      }
     }
     public static void main(String[] args) {
      String a[] = { "abc","gay" };
      System.out.println(reverseArrayToString(a,0));
     }
}
