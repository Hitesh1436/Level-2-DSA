class Solution {
    public String reverseVowels(String s) {
        String toCheck = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder(s);
        int li = 0;
        int ri = s.length() -1;
        
        while(li<ri){
           while(li<ri && toCheck.indexOf(sb.charAt(li))==-1){
               li++;
           } 
            while(li < ri && toCheck.indexOf(sb.charAt(ri))==-1){
                ri--;
            }
            char temp = sb.charAt(li);
            sb.setCharAt(li,sb.charAt(ri));
            sb.setCharAt(ri,temp);
            li++;
            ri--;
        }
        return sb.toString();
    }
}