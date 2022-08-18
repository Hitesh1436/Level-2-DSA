// Lintcode 883 · Max Consecutive Ones II

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here
        int j = 0;
        int countz = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                countz++;
            }
            // if zeroes are more make j move and remove 0's to make it valid
            while(j < i && countz > 1){
                if(nums[j] == 0){
                    countz--;
                }
                j++;
            }
            int len = i - j + 1;
            res = Math.max(res, len);
        }
        return res;
    }
}