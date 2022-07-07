class Solution {
    HashMap<String,PriorityQueue<String>>adj;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        for(List<String> tic : tickets){
            String src = tic.get(0);
            String dest = tic.get(1);
            
            if(adj.containsKey(src)){
                adj.get(src).add(dest);
            }else{
                adj.put(src,new PriorityQueue<>());
                adj.get(src).add(dest);
            }
        }
        LinkedList<String> ans = new LinkedList<>();
        dfs("JFK",ans);
        return ans;
    }
    public void dfs(String v,LinkedList<String> ans){
        if(adj.containsKey(v) ==false || adj.get(v).size()==0){
            ans.addFirst(v);
            return;
        }
        while(adj.get(v).size()>0){
            String nbr = adj.get(v).remove();
            dfs(nbr,ans);
        }
        ans.addFirst(v);
    }
}