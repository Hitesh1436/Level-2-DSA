// --------------------------------- GFG --------------------------


// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//           public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node root, int k) {
        Node curr = root;
        int count =0;
        while(curr != null){
            if(curr.left == null){
                count++;
                if(count == k){
                    return curr.data;
                }
                curr = curr.right;
            }else{
                Node iop = curr.left;
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                if(iop.right == null){
                    iop.right = curr;   // thread bnadia
                    curr = curr.left;
                }else{
                    iop.right = null;
                    count ++;
                    if(count == k){
                        return curr.data;
                    }
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}
