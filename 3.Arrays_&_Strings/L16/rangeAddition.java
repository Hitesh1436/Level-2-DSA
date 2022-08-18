//Lintcode  903 · Range Addition
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates){
        int[] res = new int[length];
        for(int[] upd: updates){
            int start = upd[0];
            int end = upd[1];
            int delta = upd[2];
            res[start] += delta;
            if(end + 1 < res.length)
                res[end + 1] -= delta;
        }
        for(int i = 1; i < res.length; i++){
            res[i] += res[i - 1];
        }
        return res;
    }
}