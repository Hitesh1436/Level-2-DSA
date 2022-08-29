// -------------------- PEPCODING--------------------------

import java.io.*;
import java.util.*;

public class Main{
    
    public static int countBrackets(int n){
        int []dp = new int[n +1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int left = 0;
            int right = i-1;
            while(left <= i-1){
                dp[i] += dp[left]* dp[right];
                left++;
                right--;
            }
        }
        return dp[n];
    }
    
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = countBrackets(n);
        System.out.println(ans);
    }
}