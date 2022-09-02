class Solution {
    public int maxProfit(int[] prices) {
        int bd = 0;  // buy day
        int sd = 0;  // selling day
        int prof = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] >= prices[i - 1]){
                sd++;
            } else {
                prof += prices[sd] - prices[bd];
                bd = sd = i;
            }
        }
        prof += prices[sd] - prices[bd];  // yeh last vale ke liye krna hoga bas
        return prof;
    }
}