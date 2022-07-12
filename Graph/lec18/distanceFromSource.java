// ------------------------------------ GFG -----------------------------------------

// ------------ BELLMAN FORD ALGORITHM --------------------------

/*
*   adj: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S){
        int []dis = new int[V];
        Arrays.fill(dis,100000000);
        dis[S] =0;
        
        for(int i=1;i<=V-1;i++){
            for(ArrayList<Integer>e : adj){   // sbhi neighbours ke liye 
                int u = e.get(0);
                int v = e.get(1);
                int p = e.get(2);
                if(dis[u] == 100000000){  // infinity show krne ke liye ek bda number leliaa humne agr dis[u] == infinity toh continue 
                    continue; 
                }else if(dis[v] == 100000000){  // dis[v] == infinity toh update krdo 
                 dis[v] = dis[u] + p;   
                }else{
                    dis[v] = Math.min(dis[v],dis[u]+p);  // koi infinity ni h toh jo value pdi h usme min 
                }
            }
        }
        return dis;
    }
}