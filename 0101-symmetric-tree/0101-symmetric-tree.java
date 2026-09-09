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
    private boolean isSameTrees(TreeNode p,TreeNode q){
      if(p==null && q==null) return true;
      if(p==null || q==null) return false;
      if(p.val!=q.val) return false;
      boolean lN=isSameTrees(p.left,q.right);
      boolean rN=isSameTrees(p.right,q.left);
      return lN && rN;
    }
    public boolean isSymmetric(TreeNode root) {
        return isSameTrees(root.left,root.right);
    }
}