//-------------------------------- GFG ---------------------------------
class GFG{
    static int index =0;
public static Node constructTree(int post[],int n){
    index = post.length-1;
    return construct(post,Integer.MIN_VALUE,Integer.MAX_VALUE);
}

private static Node construct(int post[],int min,int max){
    if(index ==-1){
        return null;
    }else if(post[index]>min && post[index]<max){
        Node ans = new Node(post[index]);
        index--;
        
        ans.right = construct(post, ans.data,max);
        ans.left = construct(post,min,ans.data);
        
        return ans;
    }else{
        return null;
    }
}
}