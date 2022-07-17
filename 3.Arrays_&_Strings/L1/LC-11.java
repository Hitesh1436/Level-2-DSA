class Solution {
    public int maxArea(int[] height){
        // Two Pointer Approach
        int ans = 0;
        int l = 0;
        int r = height.length -1;
        while(l<r){
            int area = Math.min(height[l],height[r])*(r-l);  
            // r-l -> yh width dega base ki 
            ans = Math.max(ans,area);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}