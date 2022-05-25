//--------------------------------------------GFG---------------------------------------------------

// class Solution{

//     public static int maxPathSum(Node root){
//         if(root == null) return 0;
//         int leftSide = root.data + maxPathSum(root.left);
//         int rightSide = root.data + maxPathSum(root.right);
//         return Math.max(leftSide,rightSide);
        
//     }
// }


// -------------------------------------------------------------------------------------------

class Solution{

    public static int maxPathSum(Node root){
        if(root.left!= null && root.right != null){
            int left = maxPathSum(root.left);
            int right = maxPathSum(root.right);
            return Math.max(left,right) + root.data;
        }else if(root.left != null){
            int left = maxPathSum(root.left);
            return left + root.data;
        }else if(root.right != null){
            int right = maxPathSum(root.right);
            return right + root.data;
        }else{
            return root.data;
        }
       
    }
}

//----------------------------------------------------------------------------------------------------

// class Solution{

//     public static int maxPathSum(Node root) {
//         if(root == null) return Integer.MIN_VALUE;
//         if(root.left == null && root.right == null){
//             return root.data;
//         }
//         int left = maxPathSum(root.left);
//         int right = maxPathSum(root.right);
        
//         return Math.max(left,right) + root.data;
//     }
// }


// -----------------------------------------------------------------------------------------

// class Solution{
//     static int maxSum = Integer.MIN_VALUE;
//     public static int maxPathSum(Node root){
//         maxSum = Integer.MIN_VALUE;
//         helper(root,0);
//         return maxSum;
//     }
    
//     public static void helper(Node node ,int sum){
//         if(node == null){
//             return;
//         }
//         if(node.left == null && node.right == null){
//             sum += node.data;
//             if(sum>maxSum){
//                 maxSum = sum;
//             }
//             return;
//         }
//         helper(node.left,sum + node.data);
//         helper(node.right,sum + node.data);
//     }
// }