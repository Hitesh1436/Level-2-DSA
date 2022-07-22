class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] fmap = new int[60];
        int res = 0;
        for(int t: time){
            int val = t % 60;
            // remainder 0 aaya toh 0 vale ke sth pair bnyga
            if(val == 0){
                res += fmap[0];
            } else {
                // nhi toh val - rem ke sth vale ke sth pair krwayga 
                res += fmap[60 - val];
            }
            fmap[val]++;
        }
        return res;
    }
}