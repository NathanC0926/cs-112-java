package wifi;
public class SubtreeOfAnotherTree {
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            // TODO: Implement your solution here
            if (subRoot == null) return true;
            if (root == null) return false;
            
            if (root.val == subRoot.val) return isSame(root, subRoot);
            else{
                return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
            }

        }
        public boolean isSame(TreeNode root1, TreeNode root2){  
            if (root1 == null && root2 == null) return true; // same as null
            if (root1 == null && root2 != null) return false; // one is null
            if (root1 != null && root2 == null) return false;
            if (root1.val != root2.val) return false; // not equal 
            return isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1: SubRoot is a subtree of Root
        // Root:
        //      3
        //     / \
        //    4   5
        //   / \
        //  1   2
        
        // SubRoot:
        //    4
        //   / \
        //  1   2
        TreeNode root1 = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2)),
                new TreeNode(5));
                
        TreeNode subRoot1 = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2));
        
        // Test Case 2: SubRoot is NOT a subtree of Root
        // Root:
        //      3
        //     / \
        //    4   5
        //   / \
        //  1   2
        //     /
        //    0
        
        // SubRoot:
        //    4
        //   / \
        //  1   2
        TreeNode root2 = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2,
                                new TreeNode(0),
                                null)),
                new TreeNode(5));
                
        TreeNode subRoot2 = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2));
        
        // Test Case 3: Empty subRoot is a subtree of any tree
        TreeNode root3 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
                
        TreeNode subRoot3 = null;
        
        // Test Case 4: Non-empty subRoot is not a subtree of empty root
        TreeNode root4 = null;
                
        TreeNode subRoot4 = new TreeNode(1);
        
        // Test Case 5: Identical trees
        TreeNode root5 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
                
        TreeNode subRoot5 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        
        // Test Case 6: SubRoot appears in the middle of Root
        // Root:
        //        3
        //       / \
        //      4   5
        //     / \   \
        //    1   2   6
        //       / \
        //      7   8
        
        // SubRoot:
        //    2
        //   / \
        //  7   8
        TreeNode root6 = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(8))),
                new TreeNode(5,
                        null,
                        new TreeNode(6)));
                
        TreeNode subRoot6 = new TreeNode(2,
                new TreeNode(7),
                new TreeNode(8));
        
        // Test Case 7: SubRoot has same structure but different values
        // Root:
        //      1
        //     / \
        //    2   3
        
        // SubRoot:
        //    1
        //   / \
        //  2   4  (value is different)
        TreeNode root7 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
                
        TreeNode subRoot7 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(4));
        
        // Run the test cases
        System.out.println("Test Case 1: " + solution.isSubtree(root1, subRoot1) + ", Expected: true");
        System.out.println("Test Case 2: " + solution.isSubtree(root2, subRoot2) + ", Expected: false");
        System.out.println("Test Case 3: " + solution.isSubtree(root3, subRoot3) + ", Expected: true");
        System.out.println("Test Case 4: " + solution.isSubtree(root4, subRoot4) + ", Expected: false");
        System.out.println("Test Case 5: " + solution.isSubtree(root5, subRoot5) + ", Expected: true");
        System.out.println("Test Case 6: " + solution.isSubtree(root6, subRoot6) + ", Expected: true");
        System.out.println("Test Case 7: " + solution.isSubtree(root7, subRoot7) + ", Expected: false");
    }
}