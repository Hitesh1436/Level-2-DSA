// Discuss Approach 

class Solution{

    static Node lca(Node root, int first, int second){
        if(root==null){
            return root;
        }
        
        if(root.data == first || root.data == second){
            return root;
        }
        
        Node left = lca(root.left,first,second);
        Node right = lca(root.right,first,second);
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        } 
        if(right!=null){
            return right;
        }
        return null;
    }
    
     static int multiRecurse(Node root, int tar1,int tar2, int turns, boolean side){
        if(root==null){
            // unable to find the node
            return -1;
        }
        
        if(root.data == tar1 || root.data == tar2){
            // found the node
            return turns;
        }
        int left=-1;
        int right =-1;
        if(side){
            // this is the left node of the parent, which means if we go further left
            // then there is no increment in the number of turns
            left = multiRecurse(root.left,tar1,tar2,turns,side);
            right = multiRecurse(root.right,tar1,tar2,turns+1,!side);
        } else {
            // similar as above
            left = multiRecurse(root.left,tar1,tar2,turns+1,!side);
            right = multiRecurse(root.right,tar1,tar2,turns,side);
        }
        if(left==-1){
            return right;
        } else {
            return left;
        }
    }
    
    static int solve(Node root, int first, int second){
        Node lc = lca(root,first,second);
        // traverse to the left first and check for one of the nodes and 
        // count the number of turns
        int lturns = multiRecurse(lc.left,first,second,0,true);
        // traverse to the right and check for one of the nodes and 
        // count the number of turns
        int rturns = multiRecurse(lc.right,first,second,0,false);
        // sum up the leftNumTurns + rightNumTurns + 1 is the answer;
        return lturns+rturns +1;
        
    }
    static int NumberOfTurns(Node root, int first, int second){
        return solve(root,first,second);
    }
}



// class +  self Approach



