// ----------------------------------GFG   -> Strongly Connected Components (Kosaraju's Algo)


class Solution{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis1 = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int v = 0; v < V; v++){
            if(!vis1[v]){
                dfs1(v, adj, vis1, st);
            }
        }
        
        // transpose
        ArrayList<ArrayList<Integer>> tsp = new ArrayList<>();
        for(int v = 0; v < V; v++){
            tsp.add(new ArrayList<>());
        }
        
        for(int v = 0; v < V; v++){
            for(int nbr: adj.get(v)){
                tsp.get(nbr).add(v);
            }
        }
        
        // count  mtlb scc dudho
        int count = 0;
        boolean[] vis2 = new boolean[V];
        while(st.size() > 0){
            int v = st.pop();
            if(!vis2[v]){
                dfs2(v, tsp, vis2);
                count++;
            }
        }
        
        return count;
    }
    // dfs2
    public void dfs2(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[v] = true;
        for(int nbr: adj.get(v)){
            if(!visited[nbr]){
                dfs2(nbr, adj, visited);
            }
        }
    }
    
    public void dfs1(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st){
        
        visited[v] = true;
        for(int nbr: adj.get(v)){
            if(!visited[nbr]){
                dfs1(nbr, adj, visited, st);
            }
        }
        
        st.push(v);
    }
}