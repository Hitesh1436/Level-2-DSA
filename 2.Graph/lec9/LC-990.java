class Solution {
    int []parent;
    int []rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank   = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
            rank[i] =0;
        }
        for(String eqn : equations){
            if(eqn.charAt(1) == '='){
                int op1 = eqn.charAt(0)-'a';
                int op2 = eqn.charAt(3)-'a';
                
                int l1 = find(op1);
                int l2 = find(op2);
                if(l1 != l2){
                    union(l1,l2);
                }
            }
        }
        for(String eqn : equations){
            if(eqn.charAt(1) == '!'){
                int op1 = eqn.charAt(0)-'a';
                int op2 = eqn.charAt(3)-'a';
                
                int l1 = find(op1);
                int l2 = find(op2);
                if(l1 == l2){
                    return false;
                }
            }
        }
        return true;
    }
    
   void union(int X, int Y){
        if(rank[X] < rank[Y]){
            parent[X] = Y;
        } else if(rank[Y] < rank[X]){
            parent[Y] = X;
        } else {
            parent[X] = Y;
            rank[Y]++;
        }
    }
    
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
}