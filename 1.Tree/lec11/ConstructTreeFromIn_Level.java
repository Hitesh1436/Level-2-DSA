// -----  Construct Tree From Inorder and Level-Order Traversal


class GfG{

    Node buildTree(int inord[], int level[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<level.length;i++){
            map.put(level[i],i);
        }
        // helper mn dala inord, map inord ka start idx and inord ka end index
        Node ans = helper(inord,map,0,inord.length-1);
        return ans;
    }
    private Node helper(int []inord,HashMap<Integer,Integer>map,int lo,int hi){
        if(lo>hi){
            return null;
        }
        int minidx = lo;    // assume krlia ki low of inorder has least index in level-Order 
        for(int i=lo+1;i<=hi;i++){
            if(map.get(inord[i]) < map.get(inord[minidx])){
                minidx = i;
            }
        }        
        Node node = new Node(inord[minidx]);
        node.left = helper(inord,map,lo,minidx-1);
        node.right = helper(inord,map,minidx+1,hi);
        
        return node;
    }
}


