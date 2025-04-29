/*
 * Palindrome.java
 */
   
public class Palindrome {
    // Add your definition of isPal here.

    public static boolean isPal(String s) {
        if (s == null) throw new IllegalArgumentException();
        
        String st = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        if (st.length() <= 1) return true;
        
        int n = st.length();
        ArrayStack<Character> stack = new ArrayStack<>(n);
        
        for (int i = 0; i < n/2; i++) {
            stack.push(st.charAt(i));
        }
        
        // Skip the middle character for odd-length strings
        int startIndex = (n % 2 == 0) ? n/2 : n/2 + 1;
        
        for (int i = startIndex; i < n; i++) {
            if (stack.isEmpty() || stack.pop() != st.charAt(i)) {
                return false;
            }
        }
        
        return stack.isEmpty(); // Should be empty if palindrome
    }
    

    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();
        
        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println(); // include a blank line between tests
        
        // Test 1: Empty string
        System.out.println("(1) Testing on empty string \"\"");
        try {
            boolean results = isPal("");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();
        
        // Test 2: Single character
        System.out.println("(2) Testing on single character \"a\"");
        try {
            boolean results = isPal("a");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();
        
        // Test 3: Not a palindrome
        System.out.println("(3) Testing on non-palindrome \"hello world\"");
        try {
            boolean results = isPal("hello world");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("false");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == false);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();
        
        // Test 4: Even-length palindrome
        System.out.println("(4) Testing on even-length palindrome \"abba\"");
        try {
            boolean results = isPal("abba");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        System.out.println();
        
        // Test 5: Null input
        System.out.println("(5) Testing on null input");
        try {
            boolean results = isPal(null);
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("IllegalArgumentException");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(false); // Should not reach here
        } catch (IllegalArgumentException e) {
            System.out.println("CORRECTLY THREW IllegalArgumentException");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(true);
        } catch (Exception e) {
            System.out.println("THREW UNEXPECTED EXCEPTION: " + e);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(false);
        }
    }
}