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
    List<Integer> ans = new ArrayList<>();
    
    public void rightside(TreeNode root, int count) {
        if(root == null) {
            return;
        }
        if(count == ans.size()) {
            ans.add(root.val);
        }
        rightside(root.right,count+1);
        rightside(root.left,count+1);

        return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        rightside(root,0);
        return ans;
    }
}
