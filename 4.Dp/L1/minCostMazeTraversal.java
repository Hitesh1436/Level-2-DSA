import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int [][]grid = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = scn.nextInt();
            }
        }
        int [][]dp = new int[n][m];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                // for last row
                if(i==n-1 && j == m-1){
                    dp[i][j] = grid[i][j];
                }else if(i==n-1){
                    // for last row
                    dp[i][j] = dp[i][j+1] + grid[i][j];
                }else if(j==m-1){
                    // for last coumn
                    dp[i][j] = dp[i+1][j] + grid[i][j];
                }else{
                    // bche elements ke liye krenge yhn pr
                    int min = Math.min(dp[i][j+1] , dp[i+1][j]);
                    dp[i][j] = min + grid[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }

}