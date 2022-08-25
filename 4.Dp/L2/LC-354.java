// Yeh O(n^2) ka h toh TLE degya leetcode pr

// class Solution {
//     public int maxEnvelopes(int[][] envelopes) {
//         Arrays.sort(envelopes,(a,b)->{
//            if(a[0] != b[0]){
//                return a[0]-b[0];
//            }else{
//               return b[1] - a[1];
//            } 
//         });
//         int []lis = new int[envelopes.length];
//         lis[0] = 1;
//         for(int i=1;i<lis.length;i++){
//             int max =0;
//             for(int j=0;j<i;j++){
//                 if(envelopes[j][1]< envelopes[i][1]){
//                     max = Math.max(max,lis[j]);
//                 }
//             }
//             lis[i] = max +1;
//         }
//         int len =0;
//         for(int val : lis){
//             len = Math.max(val,len);
//         }
//         return len;
//     }
// }


// Ab hoga O(nlogn) vala 


class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
         int len = 1;  
        tails[0] = nums[0];  
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > tails[len - 1]){
                len++;
                tails[len - 1] = nums[i];
            } else {
                int idx = Arrays.binarySearch(tails, 0, len - 1, nums[i]);
                if(idx < 0){
                    idx = -idx;
                    idx = idx - 1;
                }  
                tails[idx] = nums[i];
            }
        }    
        return len;
    }
}