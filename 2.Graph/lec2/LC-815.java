class Solution {
    class Pair{
        int bus;
        int csf;  // csf -> count so far
        
        Pair(int bus,int csf){
            this.bus = bus;
            this.csf = csf;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        // yh hai stop , buses ke liye ki konse stop pr kon konsi bus jati hn
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int bus =0;bus<routes.length;bus++){
            for(int stop : routes[bus]){
                if(map.containsKey(stop) == false){
                    map.put(stop,new ArrayList<>());
                }
                map.get(stop).add(bus);
            }
        }
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        for(int bsrc : map.get(source)){
            qu.add(new Pair(bsrc,1));   // bsrc -> bus source
        }
        boolean []vis = new boolean[routes.length];
        while(qu.size()>0){
            Pair rem = qu.remove();
            if(vis[rem.bus] == true){
                continue;
            }
            vis[rem.bus] = true;
            for(int rstop : routes[rem.bus]){
                if(rstop == target){
                    return rem.csf;
                }
            }
            for(int rstop : routes[rem.bus]){  // yh btarha h ki bus konse stop pr jati h
                for(int bus : map.get(rstop)){ // yh btarha h ki un stops pr konsi bus ati h
                    if(vis[bus] == false){  // unc=visited h toh add krdo 
                        qu.add(new Pair(bus,rem.csf + 1));
                    }
                }
            }
        }
        return -1;
    }
}