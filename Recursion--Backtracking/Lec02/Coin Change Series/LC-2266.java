// ========================Recursive Approach but it gives TLE===================================

// class Solution {
//     int mod = (1000000007);
   
//    public int helper(int idx , String s , int[] key){
//        // base case
//        if(idx == s.length()){
//            return 1;
//        }
//        int count = 0;
//        int num = s.charAt(idx) - '0';      // ascii ka use kia h string to number change krne mn
//        int press = key[num];
//        for(int i=0;i<press && idx+i<s.length() && s.charAt(idx)==s.charAt(idx+i);i++){
//            count += helper(idx+1+i,s,key);
//           count %= mod;
//        }
//        return count;
//    }
   
//    public int countTexts(String pressedKeys) {
//        int n = pressedKeys.length();
//        int [] key = new int []{0,0,3,3,3,3,3,4,3,4};
//        return helper(0,pressedKeys,key);
      
//    }
// }


// =======================MEMOIZATION =======================================

// class Solution {
//     int mod = (1000000007);
   
//    public int helper(int idx , String s , int[] key,int []dp){
//        // base case
//        if(idx == s.length()){
//            return 1;
//        }
//        if(dp[idx]!=-1){
//            return dp[idx];
//        }
//        int count = 0;
//        int num = s.charAt(idx) - '0';      // ascii ka use kia h string to number change krne mn
//        int press = key[num];
//        for(int i=0;i<press && idx+i<s.length() && s.charAt(idx)==s.charAt(idx+i);i++){
//            count += helper(idx+1+i,s,key,dp);
//           count %= mod;
//        }
//        return dp[idx]=count;
//    }
   
//    public int countTexts(String pressedKeys) {
//        int n = pressedKeys.length();
//        int [] key = new int []{0,0,3,3,3,3,3,4,3,4};
//        int []dp = new int[n];
//        Arrays.fill(dp,-1);
//        return helper(0,pressedKeys,key,dp);
      
//    }
// }


// ========================================TABULATION===============================================

class Solution {
    int mod = (1000000007);

    public int countTexts(String pressedKeys) {
        int[] key = new int[] { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };
        int n = pressedKeys.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int ind = n - 1; ind >= 0; ind--) {
            int count = 0;
            int num = pressedKeys.charAt(ind) - '0';
            int rep = key[num];
            for (int i = 0; i < rep && ind + i < pressedKeys.length() && pressedKeys.charAt(ind) == pressedKeys.charAt(ind + i); i++) {
                count += dp[ind+i+1];
                count %= mod;
            }
             dp[ind] = count;
        }
        return dp[0];
    }
}

