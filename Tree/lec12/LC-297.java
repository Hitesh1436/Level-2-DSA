// Approach -1 Using String Tokenizer

// import java.util.StringTokenizer;
// public class Codec {
// public String serialize(TreeNode root) {
//     StringBuilder sb = new StringBuilder();
//     serialize(root, sb);
//     return sb.toString();
// }

// private void serialize(TreeNode root, StringBuilder sb) {
//     if (root == null)
//         sb.append("# ");
//     else {
//         sb.append(root.val + " ");
//         serialize(root.left, sb);
//         serialize(root.right, sb);
//     }
// }

// // ADD "import java.util.StringTokenizer;" AT TOP ==========================
// // Decodes your encoded data to tree.
// public TreeNode deserialize(String data) {
//     if (data == null || data.length() == 0) return null;
//     StringTokenizer st = new StringTokenizer(data, " ");
//     return deserialize(st);
// }

// private TreeNode deserialize(StringTokenizer st) {
//     if (!st.hasMoreTokens())
//         return null;
//     String s = st.nextToken();
//     if (s.equals("#"))
//         return null;
//     TreeNode root = new TreeNode(Integer.valueOf(s));
//     root.left = deserialize(st);
//     root.right = deserialize(st);
    
//     return root;
//  }
// }


// Approach-2 Using Pair class

public class Codec {
    class Pair{
        TreeNode node;
        int state;
        
        public Pair(TreeNode node){
            this.node=node;
            this.state=0;
        }
    }

    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder("");
    public String serialize(TreeNode root) {
        helper(root);
        return sb.toString();
    }
    
    public void helper(TreeNode node){
        if(node==null){
            sb.append(". ");
            return;
        }
        
        sb.append(node.val+" ");
        helper(node.left);
        helper(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Stack<Pair> s=new Stack<>();
        TreeNode root=new TreeNode();
        
        
        String []str=data.split(" ");
        
        if(str[0].equals(".")){
            return null;
        }
        root.val=Integer.parseInt(str[0]);
        s.push(new Pair(root));
        
        for(int i=1;i<str.length;i++){
            if(!s.isEmpty()){
                Pair curr=s.peek();
                TreeNode newNode=new TreeNode();
            
                if(str[i].equals(".")){
                    newNode=null;
                }else{
                    newNode.val=Integer.parseInt(str[i]);
                }
                
                if(curr.state==0){
                    curr.node.left=newNode;
                }else if(curr.state==1){
                    curr.node.right=newNode;
                }
            
                curr.state=curr.state+1;
                
                if(newNode!=null){
                    s.push(new Pair(newNode));
                }  
            }
            
            while(!s.isEmpty() && s.peek().state==2){
                s.pop();
            }
        }
        
        return root;
    }
}


// Approach 3 - Without Pair class

// public class Codec {

//     // Encodes a tree to a single string.
//     static StringBuilder sb;
//     public String serialize(TreeNode root) {
//       sb = new StringBuilder();
//     serializeHelper(root);
//     return sb.toString();
// }
// public void serializeHelper(TreeNode root) {
//     if(root==null){
//         sb.append(". "); return;
//     }
//     sb.append(root.val+" ");
//     serializeHelper(root.left);
//     serializeHelper(root.right);
// }

//     // Decodes your encoded data to tree.
//     static int idx;
// public TreeNode deserialize(String data) {
//     idx = 0;
//     return deserializeHelper(data.split(" "));
// }

// public TreeNode deserializeHelper(String[] data) {
//     if(idx>=data.length || data[idx].equals(".")){
//         return null;
//     }
//     TreeNode root = new TreeNode(Integer.parseInt(data[idx]));
//     idx++;
//     root.left = deserializeHelper(data);
//     idx++;
//     root.right = deserializeHelper(data);
//     return root;
//  }
// }