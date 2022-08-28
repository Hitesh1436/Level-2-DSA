class Solution {
    public int countHousePlacements(int n) {
        int mod = 1000000007;
        long house = 1;
        long space = 1;
        for(int i=2;i<=n;i++){
            long nHouse = space;
            long nSpace = (house + space)%mod;
            
            house = nHouse;
            space = nSpace;     
        }
        long total = (house + space)%mod;
        long ans = (total * total) % mod;
        return (int)ans;
    }
}