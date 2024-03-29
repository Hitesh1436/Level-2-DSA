class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        String res = "";
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add("");
        while(queue.size() > 0){
            int sz = queue.size();
            while(sz-- > 0){
                String rem = queue.remove();
                for(int i = 0; i < 26; i++){
                    String next = rem + (char)('a' + i);
                    if(isKSub(s, next, k)){
                        res = next;
                        queue.add(next);
                    }
                }
            }
        }
        
        return res;
    }
    boolean isKSub(String s, String sub, int k){
        int j = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == sub.charAt(j)){
                j++;
                if(j == sub.length()){
                    count++;
                    j = 0;
                    if(count == k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}