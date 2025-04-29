package wifi;
public class LowestCommonAncestorInBST {
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if ((p.val <= root.val) && (root.val >= q.val)) return root; // if the root is between p and q 
            if ((q.val <= root.val) && (root.val >= p.val)) return root; 
            
            if ((p.val < root.val) && (q.val < root.val)){ // root is greater than both p and q
                return lowestCommonAncestor(root.left, p, q);
            }

            if ((p.val > root.val) && (q.val > root.val)){ // root is greater than both p and q
                return lowestCommonAncestor(root.right, p, q);
            }
            return null;
        }
        
    }
    
    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1: Basic BST
        // Tree:
        //         6
        //        / \
        //       2   8
        //      / \ / \
        //     0  4 7  9
        //       / \
        //      3   5
        TreeNode root1 = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5))),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)));
                        
        TreeNode p1 = root1.left; // Node with value 2
        TreeNode q1 = root1.right; // Node with value 8
        
        // Test Case 2: LCA is one of the nodes
        // Same tree as above, but p and q are nodes 2 and 4
        TreeNode p2 = root1.left; // Node with value 2
        TreeNode q2 = root1.left.right; // Node with value 4
        
        // Test Case 3: LCA deep in tree
        // Same tree as above, but p and q are nodes 3 and 5
        TreeNode p3 = root1.left.right.left; // Node with value 3
        TreeNode q3 = root1.left.right.right; // Node with value 5
        
        // Test Case 4: Skewed BST (all nodes to right)
        // Tree:
        //      1
        //       \
        //        2
        //         \
        //          3
        //           \
        //            4
        //             \
        //              5
        TreeNode root2 = new TreeNode(1,
                null,
                new TreeNode(2,
                        null,
                        new TreeNode(3,
                                null,
                                new TreeNode(4,
                                        null,
                                        new TreeNode(5)))));
                                        
        TreeNode p4 = root2.right.right; // Node with value 3
        TreeNode q4 = root2.right.right.right.right; // Node with value 5
        
        // Test Case 5: Skewed BST (all nodes to left)
        // Tree:
        //         5
        //        /
        //       4
        //      /
        //     3
        //    /
        //   2
        //  /
        // 1
        TreeNode root3 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(3,
                                new TreeNode(2,
                                        new TreeNode(1),
                                        null),
                                null),
                        null),
                null);
                                        
        TreeNode p5 = root3.left.left; // Node with value 3
        TreeNode q5 = root3.left; // Node with value 4
        
        // Run the test cases and verify results
        verifyResult(1, solution.lowestCommonAncestor(root1, p1, q1), root1); // Expected: 6
        verifyResult(2, solution.lowestCommonAncestor(root1, p2, q2), p2); // Expected: 2
        verifyResult(3, solution.lowestCommonAncestor(root1, p3, q3), root1.left.right); // Expected: 4
        verifyResult(4, solution.lowestCommonAncestor(root2, p4, q4), p4); // Expected: 3
        verifyResult(5, solution.lowestCommonAncestor(root3, p5, q5), q5); // Expected: 4
    }
    
    // Helper method to verify results
    private static void verifyResult(int testCase, TreeNode result, TreeNode expected) {
        if (result == expected) {
            System.out.println("Test Case " + testCase + ": PASSED");
        } else {
            System.out.println("Test Case " + testCase + ": FAILED");
            System.out.println("  Expected value: " + (expected != null ? expected.val : "null"));
            System.out.println("  Actual value: " + (result != null ? result.val : "null"));
        }
    }
}