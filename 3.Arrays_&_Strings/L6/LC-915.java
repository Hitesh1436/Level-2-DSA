// T(C) -> O(n) S(C) -> O(1)
class Solution {
    public int partitionDisjoint(int[] nums) {
        int pi = 0;         // pi -> partition index jo alag krega dono ko 
        int mtp = nums[0];  // mtp -> maximum till partition
        int mts = nums[0];  // mts -> maximum till scanned
        
        for(int i = 1; i < nums.length; i++){
            mts = Math.max(nums[i], mts);  // abtk max aya vhn mts ayga harr baar
            if(nums[i] < mtp){ 
                pi = i;  // pi chnge hota rhega agr less val ati rhi 
                mtp = mts;  // pi change hua toh mts and mtp bhi same krdenge
            }
        }
        return pi + 1;
    }
}