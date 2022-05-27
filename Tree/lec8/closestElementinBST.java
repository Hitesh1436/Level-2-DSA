// ------------------------------------- GFG -----------------------------------

class Solution{
    static int min = Integer.MAX_VALUE;
    static int minDiff(Node  root, int K){ 
        int min = Integer.MAX_VALUE;
        while(root != null){
            if(root.data <K){
                min = Math.min(min,Math.abs(K - root.data));
                root = root.right;
            }else if(root.data > K){
                min = Math.min(min,Math.abs(root.data - K));
                root = root.left;
            }else{
                return 0;
            }
        }
        return min;
    } 
}
