/*
 * 404. Sum of Left Leaves
 * Target: Find the sum of all left leaves in a given binary tree.
 * Difficulty：Easy
 * Classification：Tree
 */

/*
 * Solution 1
 * 2019-11-01  Runtime: 0 ms
 * Algorithm: => Recursion
 * Time Complexity: ?, Space Conplexity: O(1)
 */
 
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sumLeft = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sumLeft += root.left.val;
                /*System.out.println(sumLeft);*/
            } else {
                sumLeft += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            if (root.right.left != null || root.right.right != null) {
                sumLeft += sumOfLeftLeaves(root.right);
            }
        }
        return sumLeft;
    }
}
 