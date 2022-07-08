class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        rank = new int[s.length()];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
            rank[i] =0;
        }
         for(List<Integer> p : pairs){
             int i = p.get(0);
             int j = p.get(1);
             
             int iL = find(i);
             int jL = find(j);
             if(iL != jL){
                 union(iL,jL);
             }
         }
        PriorityQueue<Character>[]pq = new PriorityQueue[s.length()];  // tki lexographically order mn ajye
        for(int i=0;i<pq.length;i++){
            pq[i] = new PriorityQueue<>();
        }
        for(int i=0;i<s.length();i++){
            int iL = find(i);
            char ch = s.charAt(i);
            pq[iL].add(ch);  // jo uss index ka lead hoga uss pq mn dlega vo character
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int iL = find(i);
            char ch = pq[iL].remove();
            sb.append(ch);
        }
        return sb.toString();
    }
     int[] parent;
     int[] rank;
    void union(int x, int y){
        if(rank[x] < rank[y]){
            parent[x] = y;
        } else if(rank[y] < rank[x]){
            parent[y] = x;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
    
    int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}