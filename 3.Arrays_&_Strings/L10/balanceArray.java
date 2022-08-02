// ------------------------------ Interview Bit ------------------------------------

public class Solution {
    public int solve(ArrayList<Integer> A){
        int os = 0;  // os -> odd sum
        int es = 0;  // es -> even sum
        for(int i=0;i<A.size();i++){
            if(i % 2 ==0){
                es += A.get(i);
            }else{
                os += A.get(i);;
            }
        }
        int los = 0;  // los -> left odd sum
        int les = 0;  // les -> left even sum
        int ans =0;
        for(int i=0;i<A.size();i++){
            if(i % 2 ==0){
                int res = es - les -A.get(i);
                int ros = os - los;  // ros -> right odd sum
                if(los + res == les + ros){
                    ans++;
                }
                les += A.get(i);
            }else{
                int res = es - les;
                int ros = os - los - A.get(i);
                if(los + res == les + ros){
                    ans++;
                }
                los += A.get(i);
            }
        }
        return ans;
    }
}
