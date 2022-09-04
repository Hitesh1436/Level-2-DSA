// ------------ GFG -: Maximum Difference  


class Solution{
    int findMaxDiff(int a[], int n){ 
	    int []left = nextSmallerOnLeftt(a);
	    int []right = nextSmallerOnRight(a);
	    int max =0;
	    for(int i=0;i<a.length;i++){
	        max = Math.max(max,Math.abs(left[i]-right[i]));
	    }
	    return max;
    }
    public int[] nextSmallerOnRight(int []arr){
        int []ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<arr.length;i++){
           while(st.size()>0 && arr[st.peek()]>arr[i]){
                ans[st.peek()] = arr[i];
                st.pop();
           } 
           st.push(i);
        }
        return ans;
    }
    public int[] nextSmallerOnLeftt(int []arr){
        int []ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length -1);
        for(int i=arr.length -2;i>=0;i--){
           while(st.size()>0 && arr[st.peek()]>arr[i]){
                ans[st.peek()] = arr[i];
                st.pop();
           } 
           st.push(i);
        }
        return ans;
    }
}