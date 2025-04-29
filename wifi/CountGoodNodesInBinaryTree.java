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

public class CountGoodNodesInBinaryTree {
    /**
     * A node x is considered good if the path from the root to x does not contain
     * any nodes with a value greater than x.
     * 
     * @param root The root of the binary tree
     * @return The number of good nodes in the tree
     */
    public int goodNodes(TreeNode root) {
        // TODO: Implement this method
        return 0;
    }

    // Main method with test cases
    public static void main(String[] args) {
        CountGoodNodesInBinaryTree solution = new CountGoodNodesInBinaryTree();
        
        // Test Case 1: Example from problem statement [3,1,4,3,null,1,5]
        TreeNode root1 = new TreeNode(3,
                         new TreeNode(1, 
                             new TreeNode(3),
                             null),
                         new TreeNode(4,
                             new TreeNode(1),
                             new TreeNode(5)));
        
        int result1 = solution.goodNodes(root1);
        System.out.println("Test Case 1:");
        System.out.println("Expected: 4");
        System.out.println("Actual: " + result1);
        System.out.println("Result: " + (result1 == 4 ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 2: Example from problem statement [3,3,null,4,2]
        TreeNode root2 = new TreeNode(3,
                          new TreeNode(3,
                              new TreeNode(4),
                              new TreeNode(2)),
                          null);
        
        int result2 = solution.goodNodes(root2);
        System.out.println("Test Case 2:");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + result2);
        System.out.println("Result: " + (result2 == 3 ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 3: Single node
        TreeNode root3 = new TreeNode(1);
        int result3 = solution.goodNodes(root3);
        System.out.println("Test Case 3 (Single node):");
        System.out.println("Expected: 1");
        System.out.println("Actual: " + result3);
        System.out.println("Result: " + (result3 == 1 ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 4: Path with decreasing values
        TreeNode root4 = new TreeNode(5,
                          new TreeNode(4,
                              new TreeNode(3,
                                  new TreeNode(2),
                                  new TreeNode(1)),
                              null),
                          null);
        
        int result4 = solution.goodNodes(root4);
        System.out.println("Test Case 4 (Decreasing values):");
        System.out.println("Expected: 1");
        System.out.println("Actual: " + result4);
        System.out.println("Result: " + (result4 == 1 ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 5: Path with increasing values
        TreeNode root5 = new TreeNode(1,
                          new TreeNode(2,
                              new TreeNode(3,
                                  new TreeNode(4),
                                  new TreeNode(5)),
                              null),
                          null);
        
        int result5 = solution.goodNodes(root5);
        System.out.println("Test Case 5 (Increasing values):");
        System.out.println("Expected: 5");
        System.out.println("Actual: " + result5);
        System.out.println("Result: " + (result5 == 5 ? "PASS" : "FAIL"));
        System.out.println();
    }
}
