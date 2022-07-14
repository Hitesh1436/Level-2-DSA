// --- GFG ->Eulerian Path In Undirected Graph

class Solution{
    static int eulerPath(int N, int graph[][]){
        // code here
        int count = 0;
        
        for(int i = 0; i < graph.length; i++){
            int size = 0;
            
            for(int j = 0; j < graph.length; j++){
                if(i != j && graph[i][j] == 1){
                    size++;
                }
            }
            
            if(size % 2 == 1){
                count++;
            }
        }
        
        if(count == 0 || count == 2){
            return 1;
        } else {
            return 0;
        }
    }
}