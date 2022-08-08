class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int las = 1; // las -> lowest allowed speed
        int has = 0; // has -> highest allowed speed
        for(int pile : piles){
            has += pile;
            las = Math.max(las ,pile);
        }
        while(las < has){
            int as = (las + has)/2;
            // calculate hours 
            int totalTime = 0;
            for(int pile : piles){
                int time = (pile + as -1)/as;  // ceil chaiye tha toh humne as add kia and 1 minus kia
                totalTime += time;
            }
            if(totalTime >h){
                las = as +1;
            }else{
                has = as;
            }
        }
        return las;
    }
}