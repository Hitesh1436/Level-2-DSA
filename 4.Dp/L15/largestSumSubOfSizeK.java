// -------------------- GFG -> Largest Sum Subarray of Size at least K


class Compute {
    public long maxSumWithK(long a[], long n, long k){
        long[] res = new long[a.length];
        long csum =a[0];
        res[0] = csum;
        for(int i=1;i<a.length;i++){
            if(csum>0){
                csum += a[i];   // yeh h Kadane's algorithm
            }else{
                csum = a[i];
            }
            res[i] = csum;
        }
        long []window = new long[(int)n -(int)k +1];   // yhn se sliding window use kia h 
        for(int i=0;i<k ; i++){
            window[0] = window[0] + a[i];
        }
        for(int i=1;i<window.length;i++){
            window[i] = window[i-1] - a[i-1] + a[i + (int)k-1];
        }
        long ans = 0 + window[0];
        for(int i=0;i<window.length -1;i++){
            ans = Math.max(ans,Math.max(window[i+1],res[i] + window[i+1]));
        }
        return ans;
    }
}