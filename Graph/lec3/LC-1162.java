// Using BFS

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
    public int maxDistance(int[][] grid) {
        boolean [][]vis = new boolean[grid.length][grid[0].length];
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    qu.add(new Pair(i,j,0));
                }
            }
        }
        if(qu.size() == grid.length * grid[0].length){
            return -1;
        }
        
        int dist = -1;
        while(qu.size()>0){
            Pair rem = qu.remove();
            if(vis[rem.i][rem.j] == true){
                continue;
            }
            vis[rem.i][rem.j]= true;
            
            dist = rem.level;
            
            addNeighbours(rem.i-1,rem.j,rem.level + 1,grid,vis,qu);
            addNeighbours(rem.i+1,rem.j,rem.level + 1,grid,vis,qu);
            addNeighbours(rem.i,rem.j-1,rem.level + 1,grid,vis,qu);
            addNeighbours(rem.i,rem.j+1,rem.level + 1,grid,vis,qu);
        }
        return dist;
    }
    void addNeighbours(int i,int j,int level,int[][]grid,boolean[][]vis,ArrayDeque<Pair>qu){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1 || vis[i][j] == true){
            return;
        }
        
        qu.add(new Pair(i, j, level));
    }
    

}