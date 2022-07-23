class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        while(l < r){
            int val = people[l] + people[r];
            if(val <= limit){
                ans++;
                l++;
                r--;
            } else {
                // bas max wt vale ko dala ans++ kia nd right vale ko km krdia
                ans++;
                r--;
            }
        }
        if(l == r){  // dono idx same hn mtlb akela bchgya toh uske liie 1 add kia bas
            ans += 1;
        }
        return ans;
    }
}