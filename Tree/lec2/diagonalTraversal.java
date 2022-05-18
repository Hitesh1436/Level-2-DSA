// GFG  

// ====================== Recursive Approach ==============================

class Tree{
    static int maxDia = 0;
    void traversal(Node root,int dia,HashMap<Integer,ArrayList<Integer>>map){
        if(root == null){
            return;
        }
        if(dia>maxDia){
            maxDia = dia;
        }
        if(map.containsKey(dia)== false){
            map.put(dia,new ArrayList<>());
            map.get(dia).add(root.data);
        }else{
            map.get(dia).add(root.data);
        }
        traversal(root.left,dia+1,map);
        traversal(root.right,dia,map);
    }
    
     public ArrayList<Integer> diagonal(Node root){
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
            traversal(root,0,map);
            
            ArrayList<Integer> ans = new ArrayList<>();
            for(int d=0;d<=maxDia;d++){
                ArrayList<Integer> al = map.get(d);
                if(al == null){
                    continue;
                }
                for(int items : al){
                    ans.add(items);
                }
            }
           return ans;
      }
}



// ======================== Without Recursion && Using Queue =====================================

// static class Pair{
//     Node node;
//     int d;
//     Pair(Node node, int d){
//         this.node = node; 
//         this.d = d;
//     }
// }
// public ArrayList<Integer> diagonal(Node root){
//     ArrayList<Integer> ans = new ArrayList<>();
//     Queue<Pair> q = new LinkedList<>();
//     q.add(new Pair(root,0));
    
//     while(q.size() > 0){
//         Pair temp = q.remove();
//         ans.add(temp.node.data);
//         int lvl = temp.d;
//         if(temp.node.left != null){
//             q.add(new Pair(temp.node.left, temp.d + 1));
//         }
//         if(temp.node.right != null){
//             Node curr = temp.node.right;
//             while(curr != null){
//                 ans.add(curr.data);
//                 if(curr.left != null){
//                     q.add(new Pair(curr.left, lvl + 1));
//                 }
//                 curr = curr.right;
//             }
//         }
//     }
//     return ans;