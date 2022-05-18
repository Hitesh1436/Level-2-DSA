// GFG 

al
    
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> list = new ArrayList<>();
	    
	    if(node.left == null && node.right == null){
	        list.add(node.data);
	    } else {
	        list.add(node.data);
    	    leftWall(node.left, list);
    	    leaves(node, list);
    	    rightWall(node.right, list);
	    }
	    
	    return list;
	}
}
