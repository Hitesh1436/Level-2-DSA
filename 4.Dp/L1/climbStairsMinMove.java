import java.io.*;
import java.util.*;

public class Main {
    
    public static int solveR(int []arr, int src,int dest){
        if(src==dest){
            return 0;
        }
        int moves = Integer.MAX_VALUE - 1;
        for(int jump=1;jump<=arr[src] && jump+src<=dest;jump++){
            moves = Math.min(moves,solveR(arr,src+jump,dest));
        }
        return moves + 1;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int []arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]= scn.nextInt();
        }
        int ans = solveR(arr,0,n);
        System.out.println(ans);
    }

}