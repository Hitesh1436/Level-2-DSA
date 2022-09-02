class Solution {
    public int maxProfit(int[] prices) {
// obsp -> old bought state profit  ossp -> old sell state profit , ocsp -> old cooldown state profit 
        int obsp = -prices[0];
        int ossp = 0;
        int ocsp = 0;
        
        for(int i = 1; i < prices.length; i++){
            int nbsp = Math.max(ocsp - prices[i], obsp);
            int nssp = Math.max(obsp + prices[i], ossp);
            int ncsp = Math.max(ossp, ocsp);

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        return ossp;
    }
}