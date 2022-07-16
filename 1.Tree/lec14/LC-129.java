// Using Recursion 

class Solution {
    int total =0;
    public int sumNumbers(TreeNode root) {
        total =0;
        helper(root,0);
        return total;
    }
    private void helper(TreeNode node,int sum){
        if(node == null) return;
        
        sum = sum * 10 + node.val;
        if(node.left == null && node.right == null){
            total = total + sum;
            return;
        }
        helper(node.left,sum);
        helper(node.right,sum);
    }
}


// Using StringBuilder

// class Solution {
//     int sum =0;
//     public int sumNumbers(TreeNode root) {
//         sum =0;
//         helper(root,new StringBuilder());
//         return sum;
//     }
//     private void helper(TreeNode node,StringBuilder sb){
//         if(node == null) return;
        
//         sb.append(node.val);
//         helper(node.left,sb);
//         helper(node.right,sb);
        
//         if(node.left == null && node.right == null){
//            int num = Integer.parseInt(sb.toString());
//             sum += num;
//         }
//         sb.deleteCharAt(sb.length()-1);
//     }
// }