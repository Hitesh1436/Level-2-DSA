/* package codechef; // don't place package name! */

// ______________________----------- CodeChef -> Algebra Sum 
 //                 GFG -> Minimum and Maximum values of an expression with * and +

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int u=0;u<t;u++) {
			int n=sc.nextInt();
			long[] values=new long[n];
			char[] expr=new char[n-1];
			for(int i=0;i<n-1;i++) {
				values[i]=sc.nextLong();
				expr[i]=sc.next().charAt(0);
			}
			
			values[n-1]=sc.nextLong();
			
			long[][] dp1=new long[n+1][n+1];
			long[][] dp2=new long[n+1][n+1];
			
			for(int i=1;i<=n;i++) {
				dp1[i][i]=values[i-1];
				dp2[i][i]=values[i-1];
			}
			
			for(int len=2;len<=n;len++) {
				for(int i=1;i<=n-len+1;i++) {
					int j=i+len-1;
					long max=Long.MIN_VALUE;
					long min=Long.MAX_VALUE;
					for(int k=i;k<j;k++) {
						char exp=expr[k-1];
						if(exp=='-') {
							long val1=dp1[i][k]-dp2[k+1][j];
							long val2=dp2[i][k]-dp1[k+1][j];
							if(val1>max)max=val1;
							if(val2<min)min=val2;
						}
						else if(exp=='+') {
							long val1=dp1[i][k] + dp1[k+1][j];
							long val2=dp2[i][k] + dp2[k+1][j];
							
							if(val1>max)max=val1;
							if(val2<min)min=val2;
						}	
					}
					//System.out.println(max);
					dp1[i][j]=max;
					dp2[i][j]=min;
				}
				
			}
			System.out.println(dp1[1][n]);
		}
	}
}
