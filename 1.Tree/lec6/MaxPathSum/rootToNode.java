class Solution{

    public static int maxPathSum(Node root){

        if(root.left!= null && root.right != null){
            int left = maxPathSum(root.left);
            int right = maxPathSum(root.right);

            //leftWithoutNegativeleaf = left_dash   righttWithoutNegativeleaf = right_dash

            int left_dash = Math.max(0,left);
            int  right_dash= Math.max(0,right);
            return Math.max(left_dash,right_dash) + root.data;
        }else if(root.left != null){
            int left = maxPathSum(root.left);
            int left_dash = Math.max(0,left);
            return left_dash + root.data;
        }else if(root.right != null){
            int right = maxPathSum(root.right);
            int  right_dash= Math.max(0,right);
            return right_dash + root.data;
        }else{
            // leaf ho tab
            return root.data;
        }
       
    }
}


//---------------------------------------------------------------------------------------------------


// class Solution{
//         static int maxSum = Integer.MIN_VALUE;
//         public static int maxPathSum(Node root){
//             maxSum = Integer.MIN_VALUE;
//             helper(root,0);
//             return maxSum;
//         }
        
//         public static void helper(Node node ,int sum){
//             if(node == null){
//                 return;
//             }
           
//                 if(sum + node.data > maxSum){
//                     maxSum = sum + node.data;
//                 }
                
//             helper(node.left,sum + node.data);
//             helper(node.right,sum + node.data);
//         }
//     }

    //----------------------------------------------------------------------------------------

    // class Solution{

    //         public static int maxPathSum(Node root) {
                

    //             int left = maxPathSum(root.left);
    //             int right = maxPathSum(root.right);

    //             int left_dash = Math.max(0,left);
    //             int right_dash = math.max(0,right);

    //             return Math.max(left_dash,right_dash) + root.data;
    //         }
    //     }