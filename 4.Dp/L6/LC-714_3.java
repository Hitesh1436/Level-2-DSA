class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp = -prices[0];   // old bought state profit
        int ossp = 0;           // old sell state profit
        for(int i = 1; i < prices.length; i++){
            int nbsp = Math.max(ossp - prices[i], obsp);  // new bought state profit
            int nssp = Math.max(obsp + prices[i] - fee, ossp);  // new sell state profit
            obsp = nbsp;
            ossp = nssp;
        }
        return ossp;
    }
}