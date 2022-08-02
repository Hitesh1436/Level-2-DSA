// ----- GFG -> 

class Solution {
    int countTriplet(int arr[], int n) {
       int c=0;
       int max=Integer.MIN_VALUE;
       for(int i:arr)
        max=Math.max(max,i);
        int dp[]=new int[max+1];
        for(int i:arr){
            dp[i]++;
        }
        for(int i=0;i<n;i++){
          for(int j=i+1;j<n;j++){
              int s=arr[i]+arr[j];
              if(s<=max){
                if(dp[s]>0)
                 c++;
              }
          }
        }
        return c;
    }
}