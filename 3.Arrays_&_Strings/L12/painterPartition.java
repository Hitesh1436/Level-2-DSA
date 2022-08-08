// --------------- GFG  -> The Painter's Partition Problem-II

class Solution{
    static long minTime(int[] arr,int n,int k){
        long lta = Long.MIN_VALUE;  // lta -> lowest time allowed
        long hta = 0; // hta -> highest time allowed
        for(int a : arr){
            hta += a;
            lta = Math.max(lta,a);
        }
        while(lta < hta){
            long ta = (lta + hta)/2; // ta -> time allowed
            int paintersReqd = 1;
            int currPainterWork = 0;
            for(int val : arr){
                if(currPainterWork + val <= ta){
                    currPainterWork += val;
                    }else{
                        currPainterWork = val;
                        paintersReqd++;
                    }
                }
                if(paintersReqd > k){
                    lta = ta +1;
                }else{
                    hta = ta;
                }
            }
        return lta;
    }
}