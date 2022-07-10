// T(C) - > O()
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int []p = new int[n+1];
        int []r = new int[n+1];
        for(int i=0;i<p.length;i++){
            p[i] = i;
            r[i] = 0;
        }
        int removals =0;
        int e1 =0; // edges ke count hn for alice set
        int e2 =0; // edges ke count hn for bob set
        
        for(int []e : edges){
            if(e[0]==3){
                // vo edge jisse dono travel krskte hn sbse phle usse dkhenge
                boolean duh = union(p,r,e[1],e[2]);  //duh -> did union happened
                if(duh == false){
                    // mtlb same set mn h toh
                    removals++; // mtlb yeh edge remove hoskti h 
                }else{
                    // union hua h toh
                    e1++;  // dono ko ek ek edge milgyi 
                    e2++;
                }
            }
        }
        int []p1 = p.clone();
        int []r1 = r.clone();
        
        for(int []e : edges){
            if(e[0]==1){
                // vo edge jisse dono travel krskte hn sbse phle usse dkhenge
                boolean duh = union(p1,r1,e[1],e[2]);  //duh -> did union happened
                if(duh == false){
                    // mtlb same set mn h toh
                    removals++; // mtlb yeh edge remove hoskti h 
                }else{
                    // union hua h toh
                    e1++;  //  ek edge milgyi 
                }
            }
        }
        int []p2 = p.clone();
        int []r2 = r.clone();
        
        for(int []e : edges){
            if(e[0]==2){
                // vo edge jisse dono travel krskte hn sbse phle usse dkhenge
                boolean duh = union(p2,r2,e[1],e[2]);  //duh -> did union happened
                if(duh == false){
                    // mtlb same set mn h toh
                    removals++; // mtlb yeh edge remove hoskti h 
                }else{
                    // union hua h toh
                    e2++;  //  ek edge milgyi 
                }
            }
        }
        if(e1 != n-1 || e2 != n-1){
            return -1;
        }
        return removals;
    }
    public int find(int []p,int x){
        if(p[x]==x){
            return x;
        }else{
            p[x] = find(p,p[x]);
            return p[x];
        }
    }
    public boolean union(int []p,int []r,int x,int y){
        int xl = find(p,x);
        int yl = find(p,y);
        
        if(xl == yl){
            return false;  // union ni krne bcz same set mn h toh false
        }
        if(r[xl]<r[yl]){
            p[xl] = yl;
        }else if(r[yl]<r[xl]){
            p[yl] = xl;
        }else{
            p[yl]=xl;
            r[xl]++;
        }
        return true;
    } 
}