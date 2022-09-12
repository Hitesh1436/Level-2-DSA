// ------------ GFG-> Longest Common Substring

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int res = 0;
        
        int[][] dp = new int[S1.length() + 1][S2.length() + 1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(S1.charAt(i - 1) == S2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    res = Math.max(res, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                } 
            }
        }
        return res;
    }
}