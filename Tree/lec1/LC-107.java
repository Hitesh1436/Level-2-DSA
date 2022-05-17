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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        List<Integer> al = new ArrayList<>();
        Stack<List<Integer>> st = new Stack<>();
        
        if(root == null){
            List<List<Integer>> base = new ArrayList<>();
            return base;
        }
        while(qu.size()>0){
            TreeNode rem = qu.remove();
            
            if(rem != null){
                al.add(rem.val);
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }else{
                if(qu.size()>0){
                    qu.add(rem);
                }
                st.push(al);
                al = new ArrayList<>();
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
            while(st.size()>0){
                ans.add(st.pop());
            }
        return ans;
    }
}