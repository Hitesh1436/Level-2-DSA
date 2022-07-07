class Solution {
    public int kSimilarity(String s1, String s2) {
        HashSet<String> vis = new HashSet<>();
        ArrayDeque<String> qu = new ArrayDeque<>();
        int level =0;
        qu.add(s1);
        
        while(qu.size()>0){
            int size = qu.size();
            while(size-- >0){
                String rem = qu.remove();
                if(vis.contains(rem)){
                    continue;
                }
                vis.add(rem);
                
                if(rem.equals(s2)){
                    return level;
                }
                for(String s :getNeighbours(rem,s2)){
                    if(!vis.contains(s)){
                        qu.add(s);
                    }
                }
            }
            level++;
        }
        return -1;   
    }
    private ArrayList<String> getNeighbours(String s1, String s2){
        ArrayList<String> list = new ArrayList<String>();
        int idx = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                idx = i; break;
            }
        }
        for(int i=idx+1;i<s2.length();i++){
            if(s1.charAt(i)==s2.charAt(idx)){
                String s = swap(s1,i,idx);
                list.add(s);
            }
        }
        return list;
    }
    private String swap(String str, int i, int j){
            StringBuilder sb = new StringBuilder(str);
            char c = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,c);
            return sb.toString();
        }
    }
