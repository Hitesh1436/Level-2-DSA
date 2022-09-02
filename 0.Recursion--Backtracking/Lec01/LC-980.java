class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int x= 0 , y=0;
        int zero = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]== 0) zero++;
                if(grid[i][j]==1){
                    x = i;
                    y=j;
                }
            }
        }
        return pathFinder(grid,zero,x,y);
    }
    private int pathFinder(int [][]grid,int zero,int i,int j){
            if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1)
                return 0;
        
        if(grid[i][j]==2){
            return zero == -1 ? 1 :0;  // -1 becasue after completing all zero, for last recursion call zero would be reduced on more time 
        }
        grid[i][j]=-1;
        int count = pathFinder(grid, zero-1, i+1, j) 
                            + pathFinder(grid, zero-1, i-1, j) 
                            + pathFinder(grid, zero-1, i, j-1) 
                            + pathFinder(grid, zero-1, i, j+1) ;
        grid[i][j]=0;
        return count;
    }
}