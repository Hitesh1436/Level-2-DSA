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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        qu.add(root);
        if(root == null){
            return ans;
        }
        while(qu.size()>0){
            int size = qu.size();
            for(int i=0;i<size;i++){
                TreeNode rem = qu.remove();
                if(i== size-1){          // ans mn sirf last vale add krenge to get right view
                    ans.add(rem.val);
                }
            if(rem.left != null){
                qu.add(rem.left);
            }
            if(rem.right != null){
                qu.add(rem.right);
            }
        }
    }
    return ans;
    }   
}