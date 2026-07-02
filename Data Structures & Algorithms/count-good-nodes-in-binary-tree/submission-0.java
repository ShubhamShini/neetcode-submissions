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
    public int good(TreeNode root, int a) {
        if(root == null) return 0;
        int b = root.val<a? 0:1;
        int c = good(root.left,Math.max(root.val,a));
        int d = good(root.right,Math.max(root.val,a));
        return b+c+d;

    }
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        
        int a = good(root.left,root.val);
        int b = good(root.right,root.val);

        return a+b+1;
    }
}
