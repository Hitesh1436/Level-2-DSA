class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Integer, Node> visited = new HashMap<>();
        return helper(node, visited);
    }
    
    public Node helper(Node node, HashMap<Integer, Node> visited){
        Node clone = new Node(node.val);
        visited.put(node.val, clone);
        
        for(Node nbr: node.neighbors){
            Node nbrClone = null;
            
            if(visited.containsKey(nbr.val) == false){
                nbrClone = helper(nbr, visited);
            } else {
                nbrClone = visited.get(nbr.val);
            }
            
            clone.neighbors.add(nbrClone);
        }
        
        
        return clone;
    }
}