class Solution {
    public int consecutiveNumbersSum(int n) {
        int count =0;
        int k =1;
        int toCheck = k *(k-1)/2;
        while(toCheck < n){
            if((n - toCheck)%k == 0){
                count++;
            }
            k++;
            toCheck = k *(k -1)/2;
        }
        return count;
    }
}