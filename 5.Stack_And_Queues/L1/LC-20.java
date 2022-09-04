class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){
                st.push(ch);        // opening atey hi push krdo stack mn 
            }else{
                if(st.size()==0){   // to handle stsck underflow
                    return false;
                }
                if(ch=='}' && st.peek()!='{'){
                    return false;
                }
                if(ch==']' && st.peek()!='['){
                    return false;
                }
                if(ch==')' && st.peek()!='('){
                    return false;
                }else{
                    st.pop();
                }
            }  
        }
        if(st.size()==0){
            return true;
        }else{
            return false;
        }
    }
}