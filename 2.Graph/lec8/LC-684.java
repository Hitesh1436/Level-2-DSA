class Solution {
    int []parent;
    int []rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        rank   = new int[edges.length+1];
        
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(int []e : edges){
            int xLead = find(e[0]);
            int yLead = find(e[1]);
            if(xLead != yLead){
                union(xLead,yLead);
            }else{
                return e;
            }
        }
        return null;
    }
    public int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int xl, int yl){
        if(rank[xl] < rank[yl]){
            parent[xl] = yl;
        } else if(rank[yl] < rank[xl]){
            parent[yl] = xl;
        } else {
            parent[xl] = yl;
            rank[yl]++;
        }
    }
}