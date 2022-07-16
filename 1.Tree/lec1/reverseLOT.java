class Tree{

    public ArrayList<Integer> reverseLevelOrder(Node node) { 
        ArrayList<Integer> ans = new ArrayList<>();
        
        Queue<Node> qu = new  LinkedList<>();
        qu.add(node);
        
        Stack<Integer> st = new Stack<>();
        while(qu.size()>0){
            Node temp = qu.remove();
            
            st.push(temp.data);
            if(temp.right!=null){
                qu.add(temp.right);
            }
            if(temp.left!=null){
                qu.add(temp.left);
            }
        }
        while(st.size()>0){
            int val = st.pop();
            ans.add(val);
        }
        return ans;
    }
}     

// without using Stack==========================================

// public ArrayList<Integer> reverseLevelOrder(Node node){ 

//     ArrayList<Integer> ret = new ArrayList<>();
//     // code here
    
//     Queue<Node> queue = new LinkedList<>();
//     queue.add(node);
    

    
//     while(queue.size() > 0){
//         Node temp = queue.remove();
        
//         ret.add(temp.data);
//         if(temp.right != null){
//             queue.add(temp.right);
//         }
        
//         if(temp.left != null){
//             queue.add(temp.left);
//         }
    
//     }

//     Collections.reverse(ret);
    
    
//     return ret;
// }
// }      

//===================Reverse Level Order Line Wise String Approach 

// public static void levelOrderLineWise(Node node) {
//     Queue<Node> qu = new LinkedList<>();
//     qu.add(node);
//     qu.add(null);

//     Stack<String> st = new Stack<>();
//     Strign result = "";

//     while(qu.size()>0){
//         Node temp = qu.remove();

//         if(temp != null){
//             result+= temp.data + " ";

//             if(temp.left != null){
//                 qu.add(temp.left);
//             }
            
//             if(temp.right != null){
//                 qu.add(temp.right);
//             }
//         }else{
//             st.push(result + "\n");
//             result = "";
//             if(qu.size()>0){
//                 qu.add(temp);
//             }
//         }
//     }
//     while(st.size()>0){
//         result = st.pop();
//         System.out.println(result)
    
//     }
//   }