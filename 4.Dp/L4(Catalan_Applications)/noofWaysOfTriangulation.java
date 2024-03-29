// -------------------- PEPCODING--------------------------

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n){
		n = n-2;
		int []dp = new int[n+1];
		dp[0] =1;
		dp[1] = 1;
		for(int i=2;i<=n;i++){
		    int lt = i-1;
		    int rt =0;
		    while(lt >=0){
		        dp[i] += dp[lt] * dp[rt];
		        rt++;
		        lt--;
		    }
		}
		
		return dp[n];
	 }
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}