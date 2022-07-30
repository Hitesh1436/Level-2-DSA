class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->{
            if(a[0] > b[0]){
                return +1;
            }else if(a[0] == b[0]){
                return 0;
            }else{
                return -1;
            }
        });
        int count =1;  // ek arrow toh chalegi hi kmse km
        int end = points[0][1];
        for(int i=1;i<points.length;i++){
            int []pt = points[i];
            if(pt[0] > end){
            //agle vale ka start end ke baad khtm horha h toh mtlb arrow bdhegi
                count++;
                end = pt[1];
            }else{
        //start se phle ende horha h toh count ni bdhega and end niklega min se
                end = Math.min(end,pt[1]);
            }
        }
        return count;
    }
}