class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(0);  // sare 0 vala pswrd bnlia start mn 
        }
        HashSet<String> vis = new HashSet<>();
        vis.add(sb.toString());  // vis mn vo 0 vala dldia
        
        int limit = (int)Math.pow(k,n);
        dfs(sb,vis,limit,n,k);
        
        return sb.toString();
    }
    private boolean dfs(StringBuilder sb,HashSet<String> vis,int lim,int n,int k){
        if(vis.size()== lim){
            return true;  // mtlb answer milgya 
        }
        String lnm1 = sb.substring(sb.length()-(n-1));  // lnm1-> length n minus one mtlb last ke n-1 change krna h like kbhi 0 ya kbhi 1 add krke new pwsrd bnne ke liye 
        for(int i=0;i<k;i++){
            String npwd = lnm1 + i; // npwd - > new password
            if(!vis.contains(npwd)){  // agr new pswrd ni pda toh dalta hun usse
                vis.add(npwd);
                sb.append(i);
                boolean flag = dfs(sb,vis,lim,n,k);
                if(flag == true){
                    return true;
                }else{
                    // mtlb vis ke andr jo pswrd dala vo glt tha vo htaya vis mn se and sb se bhi delete kia
                    vis.remove(npwd);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return false;
    }
}