class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int csum = 0;  // csum -> current sum
        int osum = 0;  // osum -> overall sum
        int si = 0;  // si -> start index
        for(int i = 0; i < gas.length; i++){
            int delta = gas[i] - cost[i];
            osum += delta;
            csum += delta;
            if(csum < 0){
                csum = 0;
                si = i + 1;
            }
        }
        if(osum >= 0){
            return si;
        } else {
            return -1;
        }
    }
}