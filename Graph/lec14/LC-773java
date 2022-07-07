class Solution {
    class Pair{
        String config;
        int level;
    }
    public int slidingPuzzle(int[][] board) {
        HashSet<String> vis = new HashSet<>();
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        
        Pair rootp = new Pair();
        rootp.config = getConfig(board);
        rootp.level = 0;
        qu.add(rootp);
        
        while(qu.size()>0){
            // remove kro
            Pair rem = qu.remove();
            // mark*
            if(vis.contains(rem.config)){
                continue;
            }
            vis.add(rem.config);
            // work
            if(rem.config.equals("123450")){
                return rem.level;
            }
            // add neighbour*
            int [][]dirs = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
            int idx = rem.config.indexOf('0');
            for(int i: dirs[idx]){
                String nconfig = swap(rem.config,idx,i);  // new config aygii swap krne se
                if(!vis.contains(nconfig)){
                    Pair np = new Pair();
                    np.config = nconfig;
                    np.level = rem.level + 1;
                    qu.add(np);
                }
            }
        }
        return -1;
    }
    public String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        
        char chi = sb.charAt(i);
        char chj = sb.charAt(j);
        sb.setCharAt(i, chj);
        sb.setCharAt(j, chi);
        
        return sb.toString();
    }
    public String getConfig(int [][]grid){
        StringBuilder sb = new StringBuilder();
        for(int []row : grid){
            for(int val : row){
                sb.append(val);
            }
        }
        return sb.toString();
    }
}