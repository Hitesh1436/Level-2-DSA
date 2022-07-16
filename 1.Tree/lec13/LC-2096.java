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

    // Class Approach using AL

class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        ArrayList<TreeNode> l1 = getPath(root,startValue);
        ArrayList<TreeNode> l2 = getPath(root,destValue);
        
        int i = l1.size()-1;
        int j = l2.size()-1;
        
        while(i>=0 && j>=0){
            if(l1.get(i)== l2.get(j)){
                i--;
                j--;
            }else{
                break;
            }
        }
        i++;
        j++;
        
        StringBuilder ans = new StringBuilder();
        for(int ii=0;ii<i;ii++){
            ans.append ("U");
        }
        for(int jj=j;jj>0;jj--){
            // check krenge jj ka left child h ya right 
            if(l2.get(jj-1)== l2.get(jj).left){
                ans.append ("L");
            }else{
                ans.append ("R");
            }
        }
        return ans.toString();
    }
    private ArrayList<TreeNode> getPath(TreeNode node,int num){
        ArrayList<TreeNode> ret = new ArrayList<>();
        if(node == null){
            return new ArrayList<>();
        }
        if(node.val == num){
            ret.add(node);
            return ret;
        }else{
            // left mn check krenge
            ArrayList<TreeNode> left = getPath(node.left,num);
            if(left.size()>0){
                left.add(node);
                return left;
            }else{
                // right mn check krenge
                ArrayList<TreeNode> right = getPath(node.right,num);
            if(right.size()>0){
                right.add(node);
                return right;
            }else{
                return new ArrayList<>();
            }
        }
    }
  }
}



// 2nd Approach ->

// class Solution {
    
//     private boolean DFS(TreeNode currNode, StringBuilder path, int destVal) {
//         if(currNode == null) return false;
//         if(currNode.val == destVal) return true;
//         if(DFS(currNode.left, path, destVal)) path.append("L");
//         else if(DFS(currNode.right, path, destVal)) path.append("R");
//         return path.length() > 0;
//     }
    
//     public String getDirections(TreeNode root, int startValue, int destValue) {
//         StringBuilder startToRoot = new StringBuilder();
//         StringBuilder endToRoot   = new StringBuilder();
        
//         DFS(root, startToRoot, startValue);
//         DFS(root, endToRoot, destValue);
        
//         int i = startToRoot.length(), j = endToRoot.length();
//         int cnt = 0;
//         while(i > 0 && j > 0 && startToRoot.charAt(i-1) == endToRoot.charAt(j-1)) {
//             cnt++; i--; j--;
//         }
        
//         String sPath = "U".repeat(startToRoot.length() - cnt);
//         String ePath = endToRoot.reverse().toString().substring(cnt, endToRoot.length());
        
//         return sPath + ePath;
//     }
// }
