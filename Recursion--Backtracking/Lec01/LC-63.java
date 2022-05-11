class Solution {
    
    public boolean inRange(int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m){
            return false;
        }
        return true;
    }
    
    public int travelHelper(int sr,int sc,int dr,int dc,int[][]dir,int [][]dp,int [][]grid){
        if(sr == dr && sc == dc){
            return dp[sr][sc]=1;
        }
        
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        int count = 0;
        for(int d=0;d<dir.length;d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(inRange(r,c,dr+1,dc+1) && grid[r][c]==0){
                count += travelHelper(r,c,dr,dc,dir,dp,grid);
            }
        }
        return dp[sr][sc] = count;
    }
    
    public int travel(int n,int m,int [][]grid){
        int [][]dir = {{0,1},{1,0}};
        int [][]dp = new int[n][m];
        
        int ans = travelHelper(0,0,n-1,m-1,dir,dp,grid);
        return ans;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        if(n==0 || m==0){
            return 0;
        }
        if(obstacleGrid[0][0]==1  || obstacleGrid[n-1][m-1]==1){
            return 0;
        }
        
        return travel(n,m,obstacleGrid);
    }
}


// approach 2===============================================================================

// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//       int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int[][] dp = new int[m][n];
// 		// first row and first column can have only one possible path until there is an obstacle m then it will have zero path from there onwards
//         for(int i = 0; i < m;i++){
//             if(obstacleGrid[i][0] == 1) break;
//             dp[i][0] = 1;
//         }
//         for(int i = 0;i < n;i++){
//             if(obstacleGrid[0][i] == 1) break;
//             dp[0][i] = 1;
//         }
        
//         for(int i = 1;i < m;i++){
//             for(int j = 1;j < n;j++){
//                 if(obstacleGrid[i][j] == 1) continue;  // handling for an obstacle , dont add any paths from here and you are good
//                 dp[i][j] = dp[i][j-1] + dp[i-1][j];
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }

// approach 3===============================================================================

// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m=obstacleGrid.length;
//         int n=obstacleGrid[0].length;
//       int[][] dp = new int[m][n];

//      dp[0][0]=1;
      
// 	for (int i = 0; i < m; i++) {
// 		for (int j = 0; j < n; j++) {
//             if (obstacleGrid[i][j] == 1)
//                  dp[i][j] = 0;
//             else if (j > 0 && i>0)
//                 dp[i][j] = dp[i][j - 1]+dp[i-1][j];
//             else if(i>0 )
//                 dp[i][j] = dp[i-1][j];
//              else if(j>0)
//                 dp[i][j] = dp[i][j - 1];
// 		}
// 	}
// 	return dp[m - 1][n - 1];
//     }
// }