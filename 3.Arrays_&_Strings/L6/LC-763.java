class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map[ch - 'a'] = i;  // idx ke smne char konsa h store krdia esa krke yh rhega jse a akhri bar kis idx pr aaya 
        }
        int start = 0; 
        int end = 0; 
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            end = Math.max(end, map[ch - 'a']);  // end nikalajse a 8th tk jyga and so on
            if(i == end){  // jse hi start 8th pr aya jhn end tha
                int len = end - start + 1;  // len nikalli vhn tk ki 
                res.add(len);
                end = start = i + 1;  // end start ek agy idx pr dlkr firse vhi kaam kro
            }
        }
        return res;
    }
}