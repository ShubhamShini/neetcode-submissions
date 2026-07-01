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
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        
        if(root.val == subRoot.val) {
            boolean left = isSameTree(root.left,subRoot.left);
            boolean right = isSameTree(root.right,subRoot.right);
            return left && right;
        }else return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        
        if(root.val == subRoot.val  && isSameTree(root,subRoot)) {
            return true;
        }
        boolean b = isSubtree(root.left,subRoot);
        boolean c = isSubtree(root.right,subRoot);
        return b || c;
    }
}
