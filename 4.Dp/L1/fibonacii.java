// Memoization

// import java.io.*;
// import java.util.*;

// public class Main{

// public static void main(String[] args) throws Exception {
//     Scanner scn = new Scanner(System.in);
//     int n = scn.nextInt();
//     int []dp = new int[n+1];
//     int fn = fibonacciM(n,dp);
//     System.out.println(fn);
//  }
//     public static int fibonacciM(int n,int []dp){
//         if(n ==0 || n==1){
//             return n;
//         }
//         if(dp[n] != 0){
//             return dp[n];
//         }
//         int fnm1 = fibonacciM(n-1,dp);
//         int fnm2 = fibonacciM(n-2,dp);
        
//         int fn = fnm1 + fnm2;
//         dp[n] = fn;
//         return fn;
//     }
// }


// Tabulation 

public static int fibonacciT(int n,int []dp){
    dp[0] = 0;
    dp[1] = 1;
   for(int i=2;i<=n;i++){
       dp[i] = dp[i-1] + dp[i-2];
   }
    return dp[n];
}
