class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        
        int m1 = (m+n+1)/2;
        int m2 = (m+n+2)/2;
        
        int median1 = getKthElementFromMergedArray(nums1,nums2,m1,0,0);
        int median2 = getKthElementFromMergedArray(nums1,nums2,m2,0,0);
        
        return (median1 + median2)/2.0;
    }
    public int getKthElementFromMergedArray(int []n1,int []n2,int k,int s1,int s2){
        if(s1>=n1.length){
            return n2[s2 +k-1];
        }
        if(s2>=n2.length){
            return n1[s1 +k-1];
        }
        if(k ==1){
            return Math.min(n1[s1],n2[s2]);
        }
        int el1 = Integer.MAX_VALUE;
        if(s1 + k/2 -1<n1.length){
            el1 = n1[s1 + k/2 -1];
        }
        int el2 = Integer.MAX_VALUE;
        if(s2 + k/2 -1 < n2.length){
            el2 = n2[s2 + k/2 -1];
        }
        if(el1 < el2){
            return getKthElementFromMergedArray(n1,n2,k-k/2,s1+k/2,s2);
        }else{
            return getKthElementFromMergedArray(n1,n2,k-k/2,s1,s2+k/2);
        }
    }
}