class Solution {
    public int maxChunksToSorted(int[] arr) {
        int []minFromRight = new int[arr.length];
          minFromRight[arr.length-1] = arr[arr.length -1];
        for(int i=arr.length -2;i>=0;i--){
            minFromRight[i] = Math.min(arr[i],minFromRight[i+1]);
        }
        int ans =0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++){
            max = Math.max(max,arr[i]);
            if(max <= minFromRight[i+1]){
                ans++;
            }
        }
        return ans +1;
    }
}