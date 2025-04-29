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

public class ConstructBinaryTree {
    /**
     * Builds a binary tree from preorder and inorder traversal arrays.
     * 
     * @param preorder The preorder traversal of the binary tree
     * @param inorder The inorder traversal of the binary tree
     * @return The root of the reconstructed binary tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TODO: Implement this method
        return null;
    }
    
    // Helper method to print the tree level by level for verification
    public void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        System.out.print("Level order traversal: [");
        boolean first = true;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (first) {
                System.out.print(node.val);
                first = false;
            } else {
                System.out.print(", " + node.val);
            }
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        System.out.println("]");
    }

    // Main method with test cases
    public static void main(String[] args) {
        ConstructBinaryTree solution = new ConstructBinaryTree();
        
        // Test Case 1: Example from problem statement
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        System.out.println("Test Case 1:");
        System.out.println("Expected: Tree with root 3, left child 9, right child 20, and 20's children are 15 and 7");
        System.out.print("Actual: ");
        solution.printTree(root1);
        System.out.println();
        
        // Test Case 2: Single node
        int[] preorder2 = {1};
        int[] inorder2 = {1};
        
        TreeNode root2 = solution.buildTree(preorder2, inorder2);
        System.out.println("Test Case 2 (Single node):");
        System.out.println("Expected: Tree with single node 1");
        System.out.print("Actual: ");
        solution.printTree(root2);
        System.out.println();
        
        // Test Case 3: Left-skewed tree
        int[] preorder3 = {1, 2, 3, 4, 5};
        int[] inorder3 = {5, 4, 3, 2, 1};
        
        TreeNode root3 = solution.buildTree(preorder3, inorder3);
        System.out.println("Test Case 3 (Left-skewed tree):");
        System.out.println("Expected: Left-skewed tree with path 1->2->3->4->5");
        System.out.print("Actual: ");
        solution.printTree(root3);
        System.out.println();
        
        // Test Case 4: Right-skewed tree
        int[] preorder4 = {1, 2, 3, 4, 5};
        int[] inorder4 = {1, 2, 3, 4, 5};
        
        TreeNode root4 = solution.buildTree(preorder4, inorder4);
        System.out.println("Test Case 4 (Right-skewed tree):");
        System.out.println("Expected: Right-skewed tree with path 1->2->3->4->5");
        System.out.print("Actual: ");
        solution.printTree(root4);
        System.out.println();
        
        // Test Case 5: Complex tree
        int[] preorder5 = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] inorder5 = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        
        TreeNode root5 = solution.buildTree(preorder5, inorder5);
        System.out.println("Test Case 5 (Complex tree):");
        System.out.println("Expected: Complex tree structure");
        System.out.print("Actual: ");
        solution.printTree(root5);
        System.out.println();
    }
}