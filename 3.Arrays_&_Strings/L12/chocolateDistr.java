// --------- GFG -> Chocolate Distribution Problem

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m){
        Collections.sort(a);
        int ans = Integer.MAX_VALUE;
        for(int end = m-1;end<a.size();end++){
            int start = end -m +1;
            int diff = a.get(end) - a.get(start);
            ans = Math.min(ans,diff);
        }
        return ans;
    }
}