package wifi;

import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeRightSideView {
    /**
     * Returns the values of nodes visible from the right side of the binary tree.
     * 
     * @param root The root of the binary tree
     * @return List of node values visible from the right side
     */
    public List<Integer> rightSideView(TreeNode root) {
        // TODO: Implement this method
        return null;
    }

    // Main method with test cases
    public static void main(String[] args) {
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        
        // Test Case 1: Example from problem statement [1,2,3]
        TreeNode root1 = new TreeNode(1,
                         new TreeNode(2),
                         new TreeNode(3));
        
        List<Integer> result1 = solution.rightSideView(root1);
        System.out.println("Test Case 1:");
        System.out.println("Expected: [1, 3]");
        System.out.println("Actual: " + result1);
        System.out.println("Result: " + (Arrays.asList(1, 3).equals(result1) ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 2: Example from problem statement [1,2,3,4,5,6,7]
        TreeNode root2 = new TreeNode(1,
                          new TreeNode(2,
                              new TreeNode(4),
                              new TreeNode(5)),
                          new TreeNode(3,
                              new TreeNode(6),
                              new TreeNode(7)));
        
        List<Integer> result2 = solution.rightSideView(root2);
        System.out.println("Test Case 2:");
        System.out.println("Expected: [1, 3, 7]");
        System.out.println("Actual: " + result2);
        System.out.println("Result: " + (Arrays.asList(1, 3, 7).equals(result2) ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 3: Empty tree
        TreeNode root3 = null;
        List<Integer> result3 = solution.rightSideView(root3);
        System.out.println("Test Case 3 (Empty tree):");
        System.out.println("Expected: []");
        System.out.println("Actual: " + result3);
        System.out.println("Result: " + (Collections.emptyList().equals(result3) ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 4: Single node
        TreeNode root4 = new TreeNode(1);
        List<Integer> result4 = solution.rightSideView(root4);
        System.out.println("Test Case 4 (Single node):");
        System.out.println("Expected: [1]");
        System.out.println("Actual: " + result4);
        System.out.println("Result: " + (Arrays.asList(1).equals(result4) ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 5: Left-skewed tree
        TreeNode root5 = new TreeNode(1,
                          new TreeNode(2,
                              new TreeNode(3,
                                  new TreeNode(4),
                                  null),
                              null),
                          null);
        
        List<Integer> result5 = solution.rightSideView(root5);
        System.out.println("Test Case 5 (Left-skewed tree):");
        System.out.println("Expected: [1, 2, 3, 4]");
        System.out.println("Actual: " + result5);
        System.out.println("Result: " + (Arrays.asList(1, 2, 3, 4).equals(result5) ? "PASS" : "FAIL"));
        System.out.println();
    }
}
