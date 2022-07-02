// Approach-1 

class Solution {
    int []dsu;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int []parent = new int[edges.length+1];  // +1 isliye bcz 0 koi vrtex ni h toh 1se start h iss qstn mn
        Arrays.fill(parent,-1);
        
        boolean twopf = false;   // twopf -> two parent flag lia h yeh
        int []e1 = null;
        int []e2 = null;
        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1]; 
            
            if(parent[to]== -1){
                // parent assign ni hua toh 
                parent[to] = from;  // assign krdia parent 
            }else{
                twopf = true;  // mtlb two parent hain toh break krdo
                e2 = edges[i];
                e1 = new int []{parent[to],to};
                break; 
            }
        }
        dsu = new int[edges.length+1];
        for(int i=0;i<=edges.length;i++){
                dsu[i] =i;
        }
        
        if(twopf == false){
            // mtlb twopf false rhgya mtlb ek parent hi h toh jo edge cycle create kregi usse remove krdo vhi answer hoga
            int []res = null;
            
            for(int i=0;i<edges.length;i++){
                int from = edges[i][0];
                int to = edges[i][1];
                
                int fromLead = find(from);  // from ka lead dudhaa and to vapa usse report krta h 
                if(to == fromLead){
                    // mtlb to vala phle se hi from ka Lead h toh mtlb cycle h 
                    res = edges[i];
                    break;
                }else{
                    dsu[to] = fromLead;  // to vala fromLead ko report krega
                }
            }
            return res;
        }else{
            // check for cycle
            boolean ncf = true;  // ncf -> no cycle flag 
            
            for(int i=0;i<edges.length;i++){
                if(edges[i] == e2){
                    continue;
                }
                int from = edges[i][0];
                int to = edges[i][1];
                
                int fromLead = find(from);  // from ka lead dudhaa and to vapa usse report krta h 
                if(to == fromLead){
                    // mtlb to vala phle se hi from ka Lead h toh mtlb cycle h 
                // cycle milgyi mtlb
                    ncf = false;
                    break;
                }else{
                    dsu[to] = fromLead;  // to vala fromLead ko report krega
                }
            }
            // agr e2 ke bina cycle bnrhi h toh e1 answer hojyga and e2 add ni kia aur cycle detect ni hui mtlb e2 cycle bnwta vhi answer hota hmra
            if(ncf == true){
                return e2;
            }else{
                return e1;
            }
        }
    }
    public int find(int x){
        if(dsu[x]==x){
            return x;
        }else{
            dsu[x] = find(dsu[x]);
            return dsu[x];
        }
    }
}



// Approach -2 Using Indegree 

// class Solution{
//     public int[] findRedundantDirectedConnection(int[][] edges){
//         int n = edges.length;
//         DSU uf = new DSU(n);
//         int[] indegree = new int[n];
//         Arrays.fill(indegree,-1);
//         int f1 = -1;
//         int f2 = -1;
//         for(int i =0;i<n;i++){
//             int[] edge = edges[i];
//             int v = edge[1]-1;
//             if(indegree[v]!=-1){
//                 f1 = indegree[v];
//                 f2 = i;
//                 break;
//             }
//             else{
//                 indegree[v] = i; 
//             }
            
//         }
        
//         // block f2
//         for(int i = 0;i<n;i++){
//             int[] edge = edges[i];
//             int u = edge[0]-1;
//             int v = edge[1]-1;
            
//             if(i!=f2){
//                 if(uf.union(u,v)){
//                     if(f1!=-1) return edges[f1];
//                     return edge;
//                 }
//             }
//         }
        
        
//         return edges[f2];
//     }
// }

// class DSU{
//     private int[] parent;
//     private int[] rank;
//     DSU(int n){
//         parent = new int[n];
//         rank = new int[n];
//         for(int i = 0;i<n;i++)
//         {
//             parent[i] = i;
//         }
//     }
    
//     public int findParent(int u){
//         if(parent[u]==u) return u;
//         return parent[u] = findParent(parent[u]);
//     }
    
//     public boolean union(int u,int v){
//         int pu = findParent(u);
//         int pv = findParent(v);
//         if(pu!=pv){
//             if(rank[pu]>rank[pv]){
//                 parent[pv] = pu;
//             }
//             else if(rank[pu]<rank[pv]){
//                 parent[pu] = pv;

//             }
//             else {
//                 parent[pv] = pu;
//                 rank[pu]++;
//             }
//             return false;
//         }
//         return true;       
//     }  
// }