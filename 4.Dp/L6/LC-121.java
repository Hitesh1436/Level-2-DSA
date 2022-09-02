class Solution {
    public int maxProfit(int[] prices) {
        int bp = prices[0];  // bp-> buy point
        int prof = 0;
        for(int i = 1; i < prices.length; i++){
            bp = Math.min(bp, prices[i]);
            int pist = prices[i] - bp;  // pist -> profit if sold today 
            prof = Math.max(prof, pist);
        }
        return prof;
    }
}