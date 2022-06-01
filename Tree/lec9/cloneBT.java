//    --------------- GFG -----------------------------------------------------                     

// class Solution{
    
//     private Tree rec(Tree node, HashMap<Integer, Tree> map) {
//         if(node==null) return null;
//         Tree root;
//         if(map.containsKey(node.data)){
//             //The node already exists so we don't create a new node.
//             root = map.get(node.data);
//         }else{
//             //The node does not exist so we create a new node and add it to the HashMap.
//             root = new Tree(node.data);
//             map.put(root.data, root);
//         }
//         if(node.random!=null){
//         //If the node's random pointer is not null
//             if(map.containsKey(node.random.data)){
            
//                 //If the map contains node.random
//                 root.random = map.get(node.random.data);
//             }else{
//             //Else create a new node and add it to the map.
//                 root.random = new Tree(node.random.data);
//                 map.put(root.random.data, root.random);
//             }
//         }
//         //Recursively travel left and right;
//         root.left = rec(node.left, map);
//         root.right = rec(node.right, map);
//         //Return the root;
//         return root;
//     }
//     public Tree cloneTree(Tree tree){
//         Tree root = rec(tree, new HashMap<>());
//         return root;
//     }
// }





// Class Approach      --------------------------

/*Complete the function below
Node is as follows:
class Tree{
	int data;
	Tree left,right,random;
	Tree(int d){
		data=d;
		left=null;
		right=null;
		random=null;
	}
}*/
class Solution{
    public Tree cloneTree(Tree tree){
       createDuplicates(tree);
       setRandoms(tree);
       Tree dup = removeDuplicates(tree);
       return dup;
     }
     private void createDuplicates(Tree node){
        if(node == null) return;
        
        createDuplicates(node.left);
        createDuplicates(node.right);
        
        Tree duplicate = new Tree(node.data);
        duplicate.left = node.left;
        duplicate.right = null;
        node.left = duplicate;
     }
     private void setRandoms(Tree orig){
         if(orig == null) return;
         
         setRandoms(orig.left.left);
         setRandoms(orig.right);
         if(orig.random != null){    
         orig.left.random = orig.random.left;
         }
     }
     private Tree removeDuplicates(Tree node){
         if(node == null) return null;
         
         Tree leftDup = removeDuplicates(node.left.left);
        Tree rightDup = removeDuplicates(node.right);
        
        Tree dup = node.left;
        node.left = node.left.left;
        dup.left = leftDup;
        dup.right = rightDup;
        
        return dup;
     }
}