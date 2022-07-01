class Solution {
    int []parent;
    int []size;
    public int minMalwareSpread(int[][] graph, int[] initial) {
        parent = new int[graph.length];
        size = new int[graph.length];
        
        for(int i=0;i<graph.length;i++){
            parent[i] = i;
            size[i] = 1;
        }
         for(int i=0;i<graph.length;i++){
             for(int j=0;j<graph.length;j++){
                 if(i !=j && graph[i][j] ==1){
                     unionHelper(i,j);
                 }
             }
         }
        int []imap = new int[graph.length];  // imap -> infected ke liye h
        for(int i: initial){
            int ri = find(i);
            imap[ri]++;
        }
        
        Arrays.sort(initial);
        
        int ansIdx = initial[0];
        int ansSize = 0;
        
        for(int i: initial){
            int ri = find(i);
            if(imap[ri] == 1){  // mtlb agrbas 1 infected h vhi vala dkhenge hum
                if(size[ri]>ansSize){   // 2 ese hue jinme 1 infected h toh usse lenge jiska size jyda h
                    ansIdx = i;   // vo index in initial dedo and uske sth connected vale hn uska size
                    ansSize = size[ri];
                }
            }
        }
        return ansIdx;  // agr ni mila h toh jo sbse lowest value h initial mn uska idx dena h
    }
    int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    void unionHelper(int x, int y){
        int xl = find(x);  // xl -> xLead ,yl -> yLead
        int yl = find(y);
        
        if(size[xl] < size[yl]){
            parent[xl] = yl;
            size[yl] += size[xl];
        } else {
            parent[yl] = xl;
            size[xl] += size[yl];
        }
    }
}