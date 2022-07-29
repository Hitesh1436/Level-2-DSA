class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        // yh vo bnde hn jo intervals se phle hi daljyenge
        // jinka end point agle ke start pont se km tha voh
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        // ab merging ki baari jbtk kro jbtk start end se km ajye
        int[] interval = newInterval;
        while(i < intervals.length && intervals[i][0] <= interval[1]){
            interval[0] = Math.min(intervals[i][0], interval[0]);
            interval[1] = Math.max(intervals[i][1], interval[1]);
            i++;
        }
        res.add(interval);
        while(i < intervals.length){
            res.add(intervals[i]);
            i++;
        } 
        return res.toArray(new int[res.size()][2]);
    }
}