class Solution {
    class Pair{
        boolean isBST = true;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
    }
    public boolean isValidBST(TreeNode root) {
       Pair ans = helper(root);
        return ans.isBST;
    }
    private Pair helper(TreeNode node){
        if(node == null) return new Pair();
        Pair lp = helper(node.left);
        Pair rp = helper(node.right);
        
        Pair myP = new Pair();
        myP.min = Math.min(node.val,Math.min(lp.min,rp.min));
        myP.max = Math.max(node.val,Math.max(lp.max,rp.max));
        myP.isBST = lp.isBST && rp.isBST && node.val > lp.max && node.val < rp.min;
        
        return myP;
    }
}



// -----------------using Morris Traversal -----------------

// import java.util.Scanner;

// public class Main {
//     public static Scanner scn = new Scanner(System.in);

//     public static class TreeNode {
//         int val = 0;
//         TreeNode left = null;
//         TreeNode right = null;

//         TreeNode(int val) {
//             this.val = val;
//         }
//     }
    
//     public static TreeNode getRightMostNode(TreeNode rmn,TreeNode curr){   
             //  rightMostNode ko rmn khdo
//         while(rmn.right!=null && rmn.right!=curr){
//             rmn = rmn.right;
//         }
//         return rmn;
//     }

//     public static boolean isValidBST(TreeNode root) {
//         TreeNode prev = null,curr=root;
//         while(curr!= null){
//             TreeNode leftNode = curr.left;
//             if(leftNode == null){
//                 if(prev!=null && prev.val>curr.val){
//                     return false;
//                 }
//                 prev = curr;
//                 curr = curr.right;
//             }else{
//                 TreeNode rightMostNode = getRightMostNode(leftNode , curr);
//                 if(rightMostNode.right == null){
//                     rightMostNode.right = curr;
//                     curr = curr.left;
//                 }else{
//                     if(prev.val>curr.val){
//                         return false;
//                     }
                    
//                     rightMostNode.right = null;
//                     prev = curr;
//                     curr = curr.right;
//                 }
//             }
//         }
//         return true;
//     }

//     public static TreeNode createTree(int[] arr, int[] IDX) {
//         if (IDX[0] > arr.length || arr[IDX[0]] == -1){
//             IDX[0]++;
//             return null;
//         }

//         TreeNode node = new TreeNode(arr[IDX[0]++]);
//         node.left = createTree(arr, IDX);
//         node.right = createTree(arr, IDX);

//         return node;
//     }

//     public static void solve() {
//         int n = scn.nextInt();
//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++)
//             arr[i] = scn.nextInt();

//         int[] IDX = new int[1];
//         TreeNode root = createTree(arr, IDX);
//         System.out.println(isValidBST(root));
//     }

//     public static void main(String[] args) {
//         solve();
//     }
// }