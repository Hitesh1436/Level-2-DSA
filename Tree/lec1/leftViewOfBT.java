class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root){
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        
        while(qu.size()>0){
            int size = qu.size();
            for(int i=0;i<size;i++){
                Node rem = qu.remove();
                if(i == 0){
                    ans.add(rem.data);
                }
                
                if(rem.left!= null){
                    qu.add(rem.left);
                }
                
                if(rem.right!= null){
                    qu.add(rem.right);
                }
            }
        }
        return ans;
     
    }
}