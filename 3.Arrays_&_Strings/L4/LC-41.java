class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // jhn val -ve h ya length se bdi h vhn usse ek bdi value daldi
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = n + 1;
            }
        }
// agr value ns hoti ya brabr h toh val -1 pr jyuga and usse -ve krdunga
        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]);
            
            if(val <= n){
                int idx = val - 1;
                
                if(nums[idx] > 0){
                    nums[idx] = -1 * nums[idx];
                }
            }
        }
    //jo phle +ve number milega uske idx nikalo +1 krke answer miljyga hume 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
}