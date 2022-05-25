// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     private HashMap<Integer, Integer> map;
//     private int target;
    
//     public int pathSum(TreeNode root, int targetSum) {
//         map = new HashMap<>();
//         map.put(0, 1);
//         target = targetSum;
//         return dfs(root, 0);
//     }
    
//     private int dfs(TreeNode node, int preSum) {
//         if (node == null) {
//             return 0;
//         }
//         int ans = 0;
//         preSum += node.val;
//         ans += map.getOrDefault(preSum - target, 0);
//         map.put(preSum, map.getOrDefault(preSum, 0) + 1);
//         ans += dfs(node.left, preSum);
//         ans += dfs(node.right, preSum);
//         map.put(preSum, map.get(preSum) - 1);
//         return ans;
//     }
// }



//--------------------------------------------------

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
    int count =0;
    public int pathSum(TreeNode root, int tar) {
        if(root == null) return 0;
        
        helper(root,tar,0);
        pathSum(root.left,tar);
        pathSum(root.right,tar);
        
        return count;
    }
    
    public void helper(TreeNode node,int tar,int currSum){
        if(node == null) return;
        currSum +=node.val;
        if(currSum == tar){
            count++;
        }
        helper(node.left,tar,currSum);
        helper(node.right,tar,currSum);
    }
}