class Solution {
    public boolean backspaceCompare(String s, String t) {
        String res1 = process(s);
        String res2 = process(t);
        return res1.equals(res2);
    }
    public String process(String s){
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch != '#'){
                st.push(ch);
            } else if(st.size() > 0){
                st.pop();
            } else {
                // nothing
            }
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            char ch = st.pop();
            sb.append(ch);
        }
        return sb.toString();
    }
}




// Nados Approach 


// class Solution {
//     public boolean backspaceCompare(String s, String t) {
//         int i=s.length()-1,j=t.length()-1;
//         int b1=0,b2=0;
//         while(i>=0||j>=0)
//         {
//             while(i>=0)
//             {
//                 if(s.charAt(i)=='#')
//                 {
//                     b1++;i--;
//                 }
//                 else if(b1>0)
//                 {
//                     b1--;i--;
//                 }
//                 else
//                     break;
                      
//             }
//             while(j>=0)
//             {
//                 if(t.charAt(j)=='#')
//                 {
//                     b2++;j--;
//                 }
//                 else if(b2>0)
//                 {
//                     b2--;j--;
//                 }
//                 else
//                     break;
                      
//             }
//             if(i>=0&&j>=0)
//             {if(s.charAt(i)!=t.charAt(j))
//                 return false;
//             }
//             if ((i >= 0) != (j >= 0))
//                 return false;
//             i--;j--;
//         }
        
//         return true;
//     }
// }