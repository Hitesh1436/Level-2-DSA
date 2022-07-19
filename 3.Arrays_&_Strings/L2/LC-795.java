class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int end = -1;
        int start =-1;
        int ans =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=left && nums[i]<=right){
                end=i;
            }else if(nums[i]>left){
                end =start = i;
            }else if(nums[i]>right){
                // lesser than left
            }
            ans +=(end-start);
        }
        return ans;
    }
}