// DFS se phla component dudha fir BFS l

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
    public int shortestBridge(int[][] grid) {
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        boolean [][] vis1 = new boolean[grid.length][grid[0].length];  // vis1 mn bhre phle component sare
        boolean found = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){  // jse hi phle 1 mila dfs lgadia tki uss component ke sare 1 leaaye and queue mn bhrdia
                    dfs(grid,vis1,qu,i,j);
                    found = true;
                    break;
                }
            }
            if(found == true){
                break;
            }
        }
        
        boolean [][]vis2 = new boolean[grid.length][grid[0].length];  // tki vis1 toh mrk krdia tha ab phla 1 mlte hi continue na ho toh vis2 bnkr dobara mark kia
        while(qu.size()>0){  // fir uss qu mn failna start kia humne 
            Pair rem = qu.remove();
            if(vis2[rem.i][rem.j] == true){
                continue;
            }
            vis2[rem.i][rem.j] = true;
            
            if(grid[rem.i][rem.j] == 1){  // jse hi durse component kaphla 1 mila answer milgya hume
                return rem.level -1;
            }
            addN(grid,vis2,qu,rem.i-1,rem.j,rem.level +1);
            addN(grid,vis2,qu,rem.i,rem.j+1,rem.level +1);
            addN(grid,vis2,qu,rem.i+1,rem.j,rem.level +1);
            addN(grid,vis2,qu,rem.i,rem.j-1,rem.level +1);
        }
        return -1;
    }
    private void addN(int [][]grid,boolean[][]vis2,ArrayDeque<Pair>qu,int i,int j,int level){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return;
        }else if(vis2[i][j] == true){
            return;
        }else if(grid[i][j] == 2){
            return;
        }
        qu.add(new Pair(i,j,level));
    }
    private void dfs(int[][]grid,boolean[][]vis, ArrayDeque<Pair> qu,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || vis[i][j] == true|| grid[i][j] == 0){
            return;
        }
        vis[i][j] = true;
        qu.add(new Pair(i,j,0));  // phla component ko qu mn bhrlao nd sbka level 0 hoga
        dfs(grid,vis,qu,i-1,j);
        dfs(grid,vis,qu,i,j+1);
        dfs(grid,vis,qu,i+1,j);
        dfs(grid,vis,qu,i,j-1);
        grid[i][j] = 2;          // sbko 2 bndia jatey time phle component ke 
    }
}



// Without using boolean visited bas ussi mn krte rhee


// class Solution {
//     class Pair{
//         int i;
//         int j;
//         int level;
//         Pair(int i,int j,int level){
//             this.i = i;
//             this.j = j;
//             this.level = level;
//         }
//     }
//     public int shortestBridge(int[][] grid) {
//         ArrayDeque<Pair> qu = new ArrayDeque<>();
//         // boolean [][] vis1 = new boolean[grid.length][grid[0].length];
//         boolean found = false;
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[0].length;j++){
//                 if(grid[i][j] == 1){
//                     dfs(grid,qu,i,j);
//                     found = true;
//                     break;
//                 }
//             }
//             if(found == true){
//                 break;
//             }
//         }
        
//         // boolean [][]vis2 = new boolean[grid.length][grid[0].length];
//         while(qu.size()>0){
//             Pair rem = qu.remove();
           
//             if(grid[rem.i][rem.j] == -2){
//                 continue;
//             }
            
//             if(grid[rem.i][rem.j] == 1){
//                 return rem.level -1;
//             }
//              grid[rem.i][rem.j] = -2;
            
//             addN(grid,qu,rem.i-1,rem.j,rem.level +1);
//             addN(grid,qu,rem.i,rem.j+1,rem.level +1);
//             addN(grid,qu,rem.i+1,rem.j,rem.level +1);
//             addN(grid,qu,rem.i,rem.j-1,rem.level +1);
//         }
//         return -1;
//     }
//     private void addN(int [][]grid,ArrayDeque<Pair>qu,int i,int j,int level){
//         if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
//             return;
//         }else if(grid[i][j] == -1){
//             return;
//         }else if(grid[i][j]== -2){
//             return;
//         }
//         qu.add(new Pair(i,j,level));
//     }
//     private void dfs(int[][]grid,ArrayDeque<Pair> qu,int i,int j){
//         if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || grid[i][j] == 0 || grid[i][j] == -1){
//             return;
//         }
//         grid[i][j] = -1;
//         qu.add(new Pair(i,j,0));  // phla component ko qu mn bhrlao nd sbka level 0 hoga
//         dfs(grid,qu,i-1,j);
//         dfs(grid,qu,i,j+1);
//         dfs(grid,qu,i+1,j);
//         dfs(grid,qu,i,j-1); 
//     }
// }