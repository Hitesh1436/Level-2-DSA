class Solution {
    public boolean isUgly(int n) {
        if(n == 0){
            return false;
        }
        int []divisors = {2,3,5};
        for(int div : divisors){
            while(n % div ==0){
                n = n / div;
            }
        }
        return n ==1;
    }
}