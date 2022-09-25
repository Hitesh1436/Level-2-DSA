// Longest commom subsequence vala trick use krlii 

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n){ 
        int [][]lcs = new int[m+1][n+1];
        for(int i= m-1 ;i>=0 ; i--){
            for(int j = n-1 ; j>=0 ; j--){
                if(X.charAt(i) == Y.charAt(j)){
                    lcs[i][j] = 1 + lcs[i+1][j+1];
                }else{
                    lcs[i][j] = Math.max(lcs[i+1][j],lcs[i][j+1]);
                }
            }
        }
        return m + n - lcs[0][0];
    }
}