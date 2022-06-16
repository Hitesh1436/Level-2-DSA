// Approach 1 -> Using BFS
class Solution {
    class Pair{
        int i;
        int j;
        int level;
        
        Pair(int i,int j,int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        boolean [][]vis = new boolean[mat.length][mat[0].length];
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        
        int [][]ans = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    qu.add(new Pair(i,j,0));
                }
            }
        }
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(vis[rem.i][rem.j] == true){
                continue;
            }
            vis[rem.i][rem.j] = true;
            
            ans[rem.i][rem.j] = rem.level;
            
            addNeighbours(rem.i-1,rem.j,rem.level+1,mat,vis,qu);
            addNeighbours(rem.i+1,rem.j,rem.level+1,mat,vis,qu);
            addNeighbours(rem.i,rem.j-1,rem.level+1,mat,vis,qu);
            addNeighbours(rem.i,rem.j+1,rem.level+1,mat,vis,qu);
            
        }
        return ans;
    }
    private void addNeighbours( int i,int j,int level,int[][]mat,boolean[][]vis,ArrayDeque<Pair>qu){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || vis[i][j] == true || mat[i][j] == 0){
            return;
        }
        qu.add(new Pair(i,j,level));
    }
}

// Approach 2-> Using DP for space Optimization

/**
 * Space Optimized Dynamic Programming
 *
 * The first iteration is from top left corner to bottom right. In this
 * iteration we are checking Top and Left neighbors as they have been already
 * solved.
 *
 * The second iteration is from bottom right corner to top left corner. In this
 * iteration we are checking Bottom and Right neighbors and also compare them
 * with the result of the current cell from the previous iteration.
 *
 * Time Complexity: O(2 * M * N)
 *
 * Space Complexity: O(1) - Excluding the result space.
 *
 * M = Number of rows. N = Number of columns.
 */
// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         if (mat == null || mat.length == 0 || mat[0].length == 0) {
//             return mat;
//         }

//         int rows = mat.length;
//         int cols = mat[0].length;
//         if (rows == 1 && cols == 1) {
//             return mat;
//         }

//         int[][] result = new int[rows][cols];
//         // (rows + cols - 1) is the maximum possible distance in the matrix. Its the
//         // distance been two diagonally opposite corners.
//         int maxDistance = rows + cols;

//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 if (mat[i][j] == 0) {
//                     continue;
//                 }
//                 result[i][j] = maxDistance;
//                 if (i > 0) {
//                     result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
//                 }
//                 if (j > 0) {
//                     result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
//                 }
//             }
//         }

//         for (int i = rows - 1; i >= 0; i--) {
//             for (int j = cols - 1; j >= 0; j--) {
//                 if (mat[i][j] == 0) {
//                     continue;
//                 }
//                 if (i < rows - 1) {
//                     result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
//                 }
//                 if (j < cols - 1) {
//                     result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
//                 }
//             }
//         }

//         return result;
//     }
// }