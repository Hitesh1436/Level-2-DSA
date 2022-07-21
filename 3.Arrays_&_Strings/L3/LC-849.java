class Solution {
    public int maxDistToClosest(int[] seats) {
        int j = -1;
        int res = 0;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1){
                int ans = 0;
                if(j < 0){  // mtlb phli baar 1 mila h 
                    ans = i;
                } else {
                    ans = (i - j) / 2; // mtlb 2 baar milgya toh dono ke index minus /2 hoga
                }
                res = Math.max(res, ans);
                j = i;
            }
        }
        // yh ab last mn 1 ke baad 0 hn toh uske liye
        int ans = seats.length - 1 - j;
        res = Math.max(res, ans);
        return res;
    }
}