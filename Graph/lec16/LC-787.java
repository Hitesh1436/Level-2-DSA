class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int []dis = new int[n];  // dis -> distance array bnya h
        Arrays.fill(dis,Integer.MAX_VALUE);  // sbpr infinity dldia
        dis[src] =0;  // src vale pr  dldia bcz src to src dis 0 hoga
        
        for(int i=1;i<=k+1;i++){
            // k+1 tk chlega tbhi k stops milenge hume src and dest ko htakr
            int []dp1 = dis.clone(); // 2nd array bnai dis jsi h blkul abi tk to update dis 
            for(int []fl : flights){
                int u = fl[0];
                int v = fl[1];
                int uv = fl[2];
                
                if(dis[u] != Integer.MAX_VALUE){
                    dp1[v] = Math.min(dp1[v],dis[u]+uv);  // agr MAX se km h toh update krdia dis nikalkr
                }
            }
            dis = dp1;  
        }
        if(dis[dst] == Integer.MAX_VALUE){
                return -1;
            }else{
                return dis[dst];
        }
    }
}