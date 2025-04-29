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

public class ValidBinarySearchTree {
    /**
     * Determines if a binary tree is a valid binary search tree (BST).
     * A valid BST has the following properties:
     * - The left subtree of a node contains only nodes with keys less than the node's key.
     * - The right subtree of a node contains only nodes with keys greater than the node's key.
     * - Both the left and right subtrees must also be binary search trees.
     * 
     * @param root The root of the binary tree
     * @return true if the tree is a valid BST, false otherwise
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null && root.right != null){
            if (root.val < root.right.val) return isValidBST(root.right);
            else return false;
        }
        else if (root.left != null && root.right == null){
            if (root.val > root.left.val) return isValidBST(root.left);
            else return false;
        }
        else{
            if (root.val > root.left.val && root.val < root.right.val){
                return isValidBST(root.left) && isValidBST(root.right);
            }
            else return false;
        }


        
    }

    // Main method with test cases
    public static void main(String[] args) {
        ValidBinarySearchTree solution = new ValidBinarySearchTree();
        
        // Test Case 1: Example from problem statement [2,1,3]
        TreeNode root1 = new TreeNode(2,
                         new TreeNode(1),
                         new TreeNode(3));
        
        boolean result1 = solution.isValidBST(root1);
        System.out.println("Test Case 1:");
        System.out.println("Expected: true");
        System.out.println("Actual: " + result1);
        System.out.println("Result: " + (result1 == true ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 2: Example from problem statement [5,1,4,null,null,3,6]
        TreeNode root2 = new TreeNode(5,
                          new TreeNode(1),
                          new TreeNode(4,
                              new TreeNode(3),
                              new TreeNode(6)));
        
        boolean result2 = solution.isValidBST(root2);
        System.out.println("Test Case 2:");
        System.out.println("Expected: false");
        System.out.println("Actual: " + result2);
        System.out.println("Result: " + (result2 == false ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 3: Empty tree
        TreeNode root3 = null;
        boolean result3 = solution.isValidBST(root3);
        System.out.println("Test Case 3 (Empty tree):");
        System.out.println("Expected: true");
        System.out.println("Actual: " + result3);
        System.out.println("Result: " + (result3 == true ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 4: Single node
        TreeNode root4 = new TreeNode(1);
        boolean result4 = solution.isValidBST(root4);
        System.out.println("Test Case 4 (Single node):");
        System.out.println("Expected: true");
        System.out.println("Actual: " + result4);
        System.out.println("Result: " + (result4 == true ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 5: Valid BST with duplicate values (should be false)
        TreeNode root5 = new TreeNode(5,
                          new TreeNode(4),
                          new TreeNode(6,
                              new TreeNode(5),  // Duplicate value 5 in right subtree is invalid
                              new TreeNode(7)));
        
        boolean result5 = solution.isValidBST(root5);
        System.out.println("Test Case 5 (Duplicate values):");
        System.out.println("Expected: false");
        System.out.println("Actual: " + result5);
        System.out.println("Result: " + (result5 == false ? "PASS" : "FAIL"));
        System.out.println();
        
        // Test Case 6: Tree with negative values
        TreeNode root6 = new TreeNode(0,
                          new TreeNode(-1),
                          new TreeNode(1));
        
        boolean result6 = solution.isValidBST(root6);
        System.out.println("Test Case 6 (Negative values):");
        System.out.println("Expected: true");
        System.out.println("Actual: " + result6);
        System.out.println("Result: " + (result6 == true ? "PASS" : "FAIL"));
        System.out.println();
    }
}