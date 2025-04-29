package wifi;
public class BalancedBinaryTree {
    // TreeNode definition
    public static class TreeNode {
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
    
    // Solution class
    public static class Solution {
        public boolean isBalanced(TreeNode root) {
            // TODO: Implement your solution here
            if (root == null) return true;
            int diff = Math.abs(getDepth(root.left) - getDepth(root.right));
            return (diff > 1)? false: true;
        }
        private int getDepth(TreeNode root){
            if (root == null) return 0;
            return 1 + Math.max(getDepth(root.left),getDepth(root.right));
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1: Balanced tree
        TreeNode balancedTree = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        
        // Test Case 2: Unbalanced tree
        TreeNode unbalancedTree = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4),
                                new TreeNode(4)),
                        new TreeNode(3)),
                new TreeNode(2));
        
        // Test Case 3: Empty tree
        TreeNode emptyTree = null;
        
        // Test Case 4: Single node tree
        TreeNode singleNode = new TreeNode(1);
        
        // Test Case 5: Right heavy unbalanced tree
        TreeNode rightHeavyTree = new TreeNode(1,
                null,
                new TreeNode(2,
                        null,
                        new TreeNode(3)));
        
        // Test Case 6: Left heavy unbalanced tree
        TreeNode leftHeavyTree = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        null),
                null);
                
        // Test Case 7: Complex balanced tree
        TreeNode complexBalancedTree = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        null));
                        
        // Run the test cases
        System.out.println("Test Case 1 (Balanced Tree): " + solution.isBalanced(balancedTree) + ", Expected: true");
        System.out.println("Test Case 2 (Unbalanced Tree): " + solution.isBalanced(unbalancedTree) + ", Expected: false");
        System.out.println("Test Case 3 (Empty Tree): " + solution.isBalanced(emptyTree) + ", Expected: true");
        System.out.println("Test Case 4 (Single Node): " + solution.isBalanced(singleNode) + ", Expected: true");
        System.out.println("Test Case 5 (Right Heavy Tree): " + solution.isBalanced(rightHeavyTree) + ", Expected: false");
        System.out.println("Test Case 6 (Left Heavy Tree): " + solution.isBalanced(leftHeavyTree) + ", Expected: false");
        System.out.println("Test Case 7 (Complex Balanced Tree): " + solution.isBalanced(complexBalancedTree) + ", Expected: true");
    }
}