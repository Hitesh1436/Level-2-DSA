// --------------- GFG -> Word Break


class Sol{
    public static int wordBreak(String A, ArrayList<String> B ){
        HashSet<String> dict = new HashSet<>();
        for(String word: B){
            dict.add(word);
        }
        int[] dp = new int[A.length()];
        for(int i = 0; i < dp.length; i++){
            if(dict.contains(A.substring(0, i + 1))){
                dp[i] = 1;
            } else {
                for(int j = 0; j < i; j++){
                    if(dp[j] == 1 && dict.contains(A.substring(j + 1, i + 1))){
                        dp[i] = 1;
                    }
                }
            }
        }
        return dp[A.length() - 1];
    }
}