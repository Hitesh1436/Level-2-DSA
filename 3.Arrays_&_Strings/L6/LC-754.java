class Solution {
    public int reachNumber(int target) {
        int x =0;
        target = Math.abs(target);
        while(true){
            int range = x*(x+1)/2;
            if(range>=target && range%2 == target%2){
// agr mnle 16 h toh range toh 21 mn agyi pr 16 even h nd 21 mn 2-2 ka gap se bas odd ayenge toh hume even dkhna pdega 
                break;
            }else{
                x++;
            }
        }
        return x;
    }
}