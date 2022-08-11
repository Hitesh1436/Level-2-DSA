// ----------------------- Interview Bit-----------------

public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        if(A.size() < B){
            return -1;
        }
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        for(int val: A){
            lo = Math.max(val, lo);
            hi += val;
        }
        while(lo < hi){
            int allot = (lo + hi) / 2;
            int reqd = 1;
            int curr = 0;
            for(int val: A){
                if(curr + val <= allot){
                    curr = curr + val;
                } else {
                    curr = val;
                    reqd++;
                }
            }
            if(reqd > B){
                lo = allot + 1;
            }  else {
                hi = allot;
            }
        }
        return lo;
    }
}