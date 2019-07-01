/*
 * 98. Validate Binary Search Tree
 * Target: Given a binary tree, determine if it is a valid binary search tree (BST).
 * Difficulty：Medium
 * Classification：Tree, DFS
 */

/*
 * Solution 1
 * 2019-06-30  Runtime: ? ms
 * Algorithm: => Inorder
 * Time complexity: >, Space complexity: ?
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> res = new ArrayList<>();
        getRes(root, res);
        System.out.println(res);
        int pre = res.get(0);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) - res.get(i - 1) < pre) return false;
        }
        return true;
    }
    private void getRes(TreeNode node, List<Integer> res) {
        if (node == null) return;
        getRes(node.left, res);   
        res.add(node.val);
        getRes(node.right, res);
    }
}


/*
 * Solution 2
 * 2019-06-29  Runtime: 0 ms
 * Algorithm: => Inorder recursion
 * Time complexity: ?, Space complexity: ?
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return getRes(root, null, null);
    }
    private boolean getRes(TreeNode node, Integer lo, Integer hi) {
        if (node == null) return true;
        return (lo == null || node.val > lo) && (hi == null || node.val < hi) && 
                getRes(node.left, lo, node.val) && getRes(node.right, node.val, hi);
    }
}


/*
 * Solution 3
 * 2019-06-30  Runtime: 0 ms
 * Algorithm: => Inorder recursion
 * Time complexity: ?, Space complexity: ?
 */

class Solution {
    TreeNode prev;
        
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        
        if(!isValidBST(root.left))
            return false;
        
        if (prev != null && prev.val >= root.val)
            return false;
        
        prev = root;
        
        if (!isValidBST(root.right))
            return false;
        
        return true;
    }
}