class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int []left = new int[n];
        for(int i=0;i<n;i++){
            if(i ==0){
                left[i] = 1;;
            }else{
                left[i] = left[i-1] * nums[i-1];
            }
        }
        int right =1;
        for(int i=n-2;i>=0;i--){
            // right lia tb last vale ke liye 1 hogya toh n-2 se loop chlega actual
            right = right *nums[i+1];
            left[i] = left[i] * right;
        }
        return left;
    }
}