// ----------------------- GFG ---------------------------------------


class Solution{
    public String findOrder(String [] dict, int N, int K){
         ArrayList<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[K];
        for(int i=0;i<K;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<dict.length-1;i++){
            String w1 = dict[i];  // word nikal rhe hn dict array mn se to compare and find unmatch alphabet
            String w2 = dict[i+1];
            
            for(int j=0;j<Math.min(w1.length(),w2.length());j++){
                // words mn jiski small lenght hogi ussi ke according check hoga match and unmatch
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                
                if(ch1 != ch2){
                    graph[ch1-'a'].add(ch2-'a');  // bcz k integer h and humb ke age a dalna tha toh yh kia h
                    break;
                }
            }
        }
        boolean []vis = new boolean[K];
        Stack<Integer> st = new Stack<>();
            for(int i=0;i<K;i++){
                if(vis[i] == false){
                    topologicalSort(graph,vis,st,i);
                }
            }
            String ans ="";
            while(st.size()>0){
                ans += (char)(st.pop() +'a');
            }
            return ans;
    }
    private void topologicalSort(ArrayList<Integer>[] graph,boolean []vis , Stack<Integer> st ,int v){
        vis[v] = true;
        for(int n : graph[v]){
            if(vis[n]== false){
                topologicalSort(graph,vis,st,n);
            }
        }
        // postorder mn push krna h in stack
        st.push(v);
    }
}