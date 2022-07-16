 // ------------------------------------------ GFG ---------------------------------------------------

 class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[]){
        HashMap<Integer,Integer> oldArrMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            oldArrMap.put(nums[i],i);
        }
        Arrays.sort(nums);  // 3,5,6,10,19
        
        boolean []vis = new boolean[nums.length];
        int ans =0;
        for(int i=0;i<nums.length;i++){
            if(vis[i]== true || oldArrMap.get(nums[i])==i){
                continue;
            }
            vis[i] = true;
            int j =i;
            int cycleSize = 0;
            do{
                j = oldArrMap.get(nums[j]);
                vis[j] = true;
                cycleSize++;
            }while(j!=i);
            ans += cycleSize -1;
        }
        return ans;
    }
}