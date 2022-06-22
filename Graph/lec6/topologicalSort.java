// ---------------GFG  -> Using Kahn's Algorithm -------------------------
// Topoloical Sort is always used for Directed Acyclic Graph(DAG)


class Solution{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){ 
        int[] tsort = new int[V];
        
        int[] inDegree = new int[V];
        for(int v = 0; v < V; v++){
            for(int n: adj.get(v)){
                inDegree[n]++;   // isme indegree nikali h sbhi verices pr travel krke
            }   
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int v = 0; v < V; v++){
            if(inDegree[v] == 0){
                queue.add(v);  //jiska inDegree 0 h usse queue mn add krdooo
            }
        }
        int idx = 0;
        while(queue.size() > 0){
            int v = queue.remove();
            tsort[idx] = v;
            idx++;
            
            for(int n: adj.get(v)){
                inDegree[n]--;
                if(inDegree[n] == 0){
                    queue.add(n);
                }
            }
        }
        if(idx <V){
            return new int[] {};
        }
        return tsort;
    }
}