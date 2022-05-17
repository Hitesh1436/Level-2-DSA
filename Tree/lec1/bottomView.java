/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution{

    static class Pair{
        Node node;
        int hor =0;
    }
    
    static ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> ans = new ArrayList<>(); 
        
        HashMap<Integer,Node> map = new HashMap<>();
        int lv = 0, rv = 0;                  // leftVertical , rightVertical
        
        Queue<Pair> qu = new LinkedList<>();
        
        Pair p = new Pair();
        p.node = root;
        p.hor = 0;
        
        qu.add(p);
        
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(rem.hor<lv){
                lv = rem.hor;
            }
            if(rem.hor>rv){
                rv = rem.hor;
            }
           
                map.put(rem.hor,rem.node);
                
            if(rem.node.left != null){
                Pair lp = new Pair();
                lp.node = rem.node.left;
                lp.hor = rem.hor - 1;
                
                qu.add(lp);
            }
            if(rem.node.right != null){
                Pair rp = new Pair();
                rp.node = rem.node.right;
                rp.hor = rem.hor + 1;
                
                qu.add(rp);
            }
        }
            for(int i=lv;i<=rv;i++){
                ans.add(map.get(i).data);
            }
        return ans;
    }
}