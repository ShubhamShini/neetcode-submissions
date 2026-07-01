/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    boolean balanced = true;

    public int height(TreeNode root) {
        if(root == null) return 0;
        int a = height(root.left);
        int b = height(root.right);
        if((a-b)< -1 || (a-b) > 1) {
            balanced = false;
        }
        return Math.max(a,b)+1;
    }
    public boolean isBalanced(TreeNode root) {
        height(root);
        return balanced;
    }
}
