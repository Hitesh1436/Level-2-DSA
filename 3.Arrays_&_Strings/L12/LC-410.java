class Solution {
    public int splitArray(int[] nums, int m) {
        int lowest_sum_allowed = 0;
        int highest_sum_allowed = 0;
        for(int num : nums){
            highest_sum_allowed += num;
            lowest_sum_allowed = Math.max(lowest_sum_allowed,num);  // min itne ki toh partition ho ki sbse bdi value akeli aaske
        }
        while(lowest_sum_allowed<highest_sum_allowed){
            int limit = (lowest_sum_allowed + highest_sum_allowed)/2;  // mid ko hi limit khdia h bas
            int countPartitions = 1;
            int currPartitionSum =0;
            for(int num : nums){
                if(currPartitionSum + num <=limit){
                    currPartitionSum += num;
                }else{
                    currPartitionSum = num;
                    countPartitions++;
                }
            }
            if(countPartitions > m){
                // toh mtlb lmit tight rkhi toh loose krna hoga means right jana hoga
                lowest_sum_allowed = limit +1;
            }else{
                highest_sum_allowed = limit;
            }
        }
        return lowest_sum_allowed;
    }
}