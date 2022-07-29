class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int fl, int sl) {
        int max1 = getMax(nums, fl, sl); // fl vala phle hoskta h sl vala bdmn 
        int max2 = getMax(nums, sl, fl); // ya sl vala phle and fl vala badmn toh uske liye dono ko compare krke 
        return Math.max(max1, max2);     // max answr bnega
    }
    // fl ->firstLength ,sl -> secondLength
    public int getMax(int[] nums, int fl, int sl){
        int[] left = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            // mtlb jb phli window milegi fl length jitni
            if(i == fl - 1){
                left[i] = sum;
            } else if(i >= fl){
// uske baad ke liye piche ka minus kia and agey ka ek add krke,compare krke max dalenge
                sum -= nums[i - fl];
                left[i] = Math.max(left[i - 1], sum);
            }
        }
        int[] right = new int[nums.length];
        sum = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            sum += nums[i];
            if(i == nums.length - sl){
                // mtlb jb phli window milegi sl length jitni
                right[i] = sum;
            } else if(i < nums.length - sl){
// uske baad ke liye piche ka minus kia and agey ka ek add krke,compare krke max dalenge
                sum -= nums[i + sl];
                right[i] = Math.max(sum, right[i + 1]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = fl - 1; i < nums.length - sl; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}