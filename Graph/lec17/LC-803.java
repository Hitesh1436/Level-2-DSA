class Solution {
    int m;
    int n;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        m = grid.length;
        n = grid[0].length;
        // m*n +1 -> bcz ek extra lia h tki top valo ka union sbse upr 0(i.e roof) vle ke sth hoske
        parent = new int[m*n+1];
        rank = new int[m*n+1];
        size = new int[m*n+1];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
            rank[i] =0;
            size[i] =1;
        }
        for(int []h : hits){
            int x = h[0];
            int y =h[1];
            if(grid[x][y]==1){ // mtlb agr uss location pr brick thi toh usse fodoo 
                grid[x][y] = 2;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    processNbrs(grid, i, j);
                }
            }
        }
        // brick ko process krna start kia ab
        int[] res = new int[hits.length];
        // reverse mn brick create krna start kia humne nd yh vali brick bndii
        for(int i = hits.length - 1; i >= 0; i--){
            int x = hits[i][0];
            int y = hits[i][1];
            
            if(grid[x][y] == 2){  // mtlb yhn futi brick thi tbhi kuch krna hoga
                int brickCount = size[find(0)];  //brick bnane se phle dkha ki 0 ke andr kya size h and ke lead ka size dkho kya pta 0 lead na ho toh uske lead ka size dkhna hoga
                grid[x][y] = 1;  // brick bnai h futi thi isliye
                processNbrs(grid, x, y);   // koi brick judni hogi judd gyi hogi toh new brick nikalii
                int newBrickCount = size[find(0)];//brick bnane ke baad dkho ki 0 ke andr kya size h and 0 ke lead ka size dkho kya pta 0 lead na ho toh uske lead ka size dkhna hoga
               if(newBrickCount > brickCount){
                    res[i] = Math.max(0, newBrickCount - brickCount - 1);
               }else{
                   res[i]=0;  // mtlb agr new brick nd phle vli brickcount same h mtlb kuch change ni hua toh yh kia
               }
            }
        }
        return res;
    }
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    void processNbrs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        int box = i * n + j + 1;  // box number nikala h grid se 
    
        for(int[] dir: dirs){
            int ni = i + dir[0];  // ni-> neighbour ka i
            int nj = j + dir[1];  // ni-> neighbour ka j
            // check kia valid bhi h ya ni mtlb grid mn rhna chaiye na nd iss nbr pr brick h ya ni
            if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 1){
                int nbox = ni * n + nj + 1;  // nbox-> neighbour bos nikala
                union(box, nbox);
            }
        }
        if(i == 0){  // roof h toh union krdo roof ke sth apne box ka
            union(box, 0);
        }
    }
    int []parent;
    int []rank;
    int []size;
    int find(int x){
        if(parent[x] ==x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    void union(int x,int y){
        int xl = find(x);
        int yl = find(y);
        if(xl == yl){
            return;
        }
        if(rank[xl]<rank[yl]){
            parent[xl]= yl;
            size[yl]+=size[xl];
        }else if(rank[yl]<rank[xl]){
            parent[yl]= xl;
            size[xl]+= size[yl];
        }else{
            parent[yl]= xl;
            size[xl]+= size[yl];
            rank[xl]++;
        }
    }
}