class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lac = 0;  // lac -> lowest allowed capacity
        int hac =0;  // hac -> highest allowed capacity
        for(int wt : weights){
            hac += wt;
            lac = Math.max(lac,wt);
        }
        while(lac < hac){
            int ac = (lac + hac)/2;  // mid ko hi ac i.e allowed capacity khdia h bas
            int partReqd = 1;  // partitions required
            int currPartWt = 0;  // current partition weight
            for(int wt : weights){
                if(currPartWt + wt <= ac){
                    currPartWt += wt;
                }else{
                     currPartWt = wt;
                    partReqd++;
                }
            }
            if(partReqd > days){
                lac = ac +1;
            }else{
                hac = ac;
            }
        }
        return lac;
    }
}