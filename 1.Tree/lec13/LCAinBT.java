// if both elements are present or both are absent 

class Solution
{
    //Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1,int n2){
	
	Node lca = helper(root,n1,n2);
	return lca;
	}
	Node helper(Node node,int n1,int n2){
	    if(node == null){
	        return null;
	    }
	    Node left  = helper(node.left,n1,n2);
	    Node right = helper(node.right,n1,n2);
	    
	    if(node.data == n1 || node.data == n2){
	        return node;
	    }else if(left != null && right != null){
	        return node;
	    }else if(left != null || right != null){
	        return left != null ? left : right;
	    }else{
	        return null;
	    }
	}
}

// if either one is absent or both are absent


// class Solution{
//     boolean f1 = false;
//     boolean f2 = false;
    
// Node lca(Node root, int n1,int n2){

// Node lca = helper(root,n1,n2);
// if(f1 && f2){
// return lca;
// }else{
//     return null;
// }
// }
// Node helper(Node node,int n1,int n2){
//     if(node == null){
//         return null;
//     }
//     Node left  = helper(node.left,n1,n2);
//     Node right = helper(node.right,n1,n2);
    
//     if(node.data == n1){
//         f1 = true;
//         return node;
//     }else if(node.data == n2){
//         f2 = true;
//         return node;
//     }else if(left != null && right != null){
//         return node;
//     }else if(left != null){
//         return left;
//     }else if(right != null){
//         return right;
//     }else{
//         return null;
//     }
//  }
// }