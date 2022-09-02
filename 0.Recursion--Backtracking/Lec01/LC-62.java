class Solution {
    
    public boolean inRange(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }
    
    public int travelHelper(int sr, int sc, int dr, int dc, int [][] dir, int [][] dp){
        if(sr == dr && sc == dc){
            return dp[sr][sc] = 1;
        }
        
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }
        
        int count  = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(inRange(r,c,dr + 1, dc + 1)){
                count += travelHelper(r,c, dr, dc, dir, dp);
            }
        }
        return dp[sr][sc] = count;

    }
    
    public int travel(int n, int m){
        
       
        int [][] dir = {{0,1}, {1,0}};
        int [][] dp = new int[n][m];
        int ans = travelHelper(0,0,n-1,m-1,dir,dp);
        return ans;
    }
    
   
    public int uniquePaths(int n, int m) {
        return travel(n,m);
    }
 }
