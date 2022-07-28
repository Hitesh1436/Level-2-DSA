class Solution {
    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        } 
        // arryay bnya ek n+1 size ka sbme true daldia 
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;  // yh ni hoga isliye cut kia
        primes[1] = false;  // yh ni hoga isliye cut kia
        
        for(int tbl = 2; tbl * tbl <= n; tbl++){
            if(primes[tbl] == false){  // pjle se cut kia hua h toh kuch ni bas continue
                continue;
            }
            for(int ja = tbl; tbl * ja <= n; ja++){
                primes[tbl * ja] = false;  // cut krdia humne uusse false krke
            }
        }
        int count = 0;
        for(int i = 0; i < primes.length - 1; i++){
            if(primes[i] == true){  // jo true bch gye vo sb prime honge so count krlo and 
                count++;  // ans dedo
            }
        }
        return count;
    }
}