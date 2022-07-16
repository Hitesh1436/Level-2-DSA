// -------------------------using range i.e min and max

class Solution {
    int index =0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private TreeNode construct(int []pre , int min,int max){
        if(index == pre.length){
            return null;
        }else if(pre[index]>min && pre[index]<max){
            TreeNode ans = new TreeNode(pre[index]);
            index++;
            
            ans.left = construct(pre,min,ans.val);
            ans.right = construct(pre,ans.val,max);
            
            return ans;
        }else{
            return null;
        }
    }
}


// --------------------using only max bcz preorder h 

// class Solution {
//     int index =0;
//     public TreeNode bstFromPreorder(int[] preorder) {
//         return construct(preorder,Integer.MAX_VALUE);
//     }
//     private TreeNode construct(int []pre ,int max){
//         if(index == pre.length){
//             return null;
//         }else if(pre[index]<max){
//             TreeNode ans = new TreeNode(pre[index]);
//             index++;
            
//             ans.left = construct(pre,ans.val);
//             ans.right = construct(pre,max);
            
//             return ans;
//         }else{
//             return null;
//         }
//     }
// }
