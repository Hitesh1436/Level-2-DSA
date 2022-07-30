class Solution {
    long MOD = 1000000007L;
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);  // sort mara array ko
        long ans = 0;
        long p = 1;
        int j = nums.length -1;
        for(int i = 0; i < nums.length; i++){
//ans mn add hoga agey se mtlb positive vale and jo piche se hain  vo minus krdo and pure ka mod krke denge vaps
// sbse bda number h vo adhe elements mn add horha hoga and 
            ans = (ans + p * nums[i] - p * nums[j]) % MOD;
            p = (p * 2) % MOD;// yh vhi h next pr jyunga toh p * 2 hojyga jse phle 1 fir 2 fir 4
            j--;
        }
        return (int)ans;
    }
}
