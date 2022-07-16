// --------------------------------  GFG --------------------------------------
// -----------------                        Ford Fulkerson Algorithm ------
// -----------------------T(C) = O(maxFlow*(V + E))
// ---------------------------------------------------  Using BFS

class Solution{
    int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges){  
        int mflow = 0;                        // maximum flow
        
        int [][] graph = new int[N+1][N+1];   // original graph
        int [][] rgraph = new int[N+1][N+1];  // residual graph 
        for(ArrayList<Integer>e : Edges){
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);
            
            graph[u][v] += w;
            graph[v][u] += w;
            
            rgraph[u][v] += w;
            rgraph[v][u] += w;
        }  
            int []par = new int[N+1];  // parent dkhne ke ki kis kiske bich mn edge h
            while(pathFound(par,rgraph)==true){
                int flow = Integer.MAX_VALUE;
                
                int v = N;  // last vertex pr rkha 
                while(v!= 1){
                    int pv = par[v];  // pv-> parent of v niklege ese
                    int price = rgraph[pv][v];
                    if(price < flow){
                        flow = price;
                    }
                    v = pv;
                }
                v = N;
                // ulta jatey hue sbki capacity bhi km krni hogi  and ulti direction mn add krenge capacity
                while(v != 1){
                    int pv = par[v];  // pv-> parent of v niklege ese
                   rgraph[pv][v] -= flow;
                   rgraph[v][pv] += flow;
                   
                   v = pv;
                }
                
                mflow += flow;
            }
        return mflow;
    }
    boolean pathFound(int []par,int [][]rgraph){
        ArrayDeque<Integer>qu = new ArrayDeque<>();
        boolean []vis = new boolean[par.length];
        
        qu.add(1);
        while(qu.size()>0){
            int rem = qu.remove();
            
            if(vis[rem]){
                continue;
            }
            vis[rem] = true;
            if(rem == par.length-1){
                return true;
            }
            for(int n=1;n<rgraph.length;n++){
                if(rgraph[rem][n]>0 && !vis[n]){
                    qu.add(n);
                    par[n] = rem;
                }
            }
        }
        return false;
    }
}



// ------------------ DFS Approach

// class Solution 
// { 
//     int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
//     { 
//         int mflow = 0;
        
//         int[][] graph = new int[N + 1][N + 1];
//         int[][] rgraph = new int[N + 1][N + 1];
//         for(ArrayList<Integer> edge: Edges){
//             int u = edge.get(0);
//             int v = edge.get(1);
//             int w = edge.get(2);
            
//             graph[u][v] += w;
//             graph[v][u] += w;
            
//             rgraph[u][v] += w;
//             rgraph[v][u] += w;
//         }
//         int[] par = new int[N + 1];
//         boolean[] vis = new boolean[N + 1];
//         while(pathFound(par, rgraph, 1, N, vis) == true){
//             int flow = Integer.MAX_VALUE;
            
//             int v = N;
//             while(v != 1){
//                 int pv = par[v];
//                 int price = rgraph[pv][v];
//                 if(price < flow){
//                     flow = price;
//                 }
//                 v = pv;
//             }
//             v = N;
//             while(v != 1){
//                 int pv = par[v];
//                 rgraph[pv][v] -= flow;
//                 rgraph[v][pv] += flow;
                
//                 v = pv;
//             } 
//             mflow += flow;
//             vis = new boolean[N + 1];
//         }
//         return mflow;
//     }
    
//     boolean pathFound(int[] par, int[][] rgraph, int s, int d, boolean[] vis){
//         vis[s] = true;
//         if(s == d){
//             return true;
//         }
//         for(int n = 1; n < rgraph.length; n++){
//             if(rgraph[s][n] > 0 && !vis[n]){
//                 par[n] = s;
//                 boolean pfFromChild = pathFound(par, rgraph, n, d, vis);
                
//                 if(pfFromChild){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }  
// }