/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1){
            return true;
        }
        // Write your code here
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        int i = 0;
        for(Interval inv: intervals){
            start[i] = inv.start;
            end[i] = inv.end;
            i++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        System.out.println(Arrays.toString(start));
        System.out.println(Arrays.toString(end));
        i = 0;
        int j = 0;
        int count = 0;
        int reqd = 0;
        while(i < start.length && j < end.length){
            if(start[i] < end[j]){
                i++;
                count++;
            } else {
                j++;
                count--;
            }

            System.out.println(count);

            reqd = Math.max(count, reqd);
        }

        return reqd == 1;
    }
}
Footer
© 2022 GitHub, Inc.