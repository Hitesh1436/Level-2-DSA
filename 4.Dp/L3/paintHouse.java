// -------------------- PEPCODING--------------------------


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [][]arr = new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
            arr[i][2] = scn.nextInt();
        }
        int red = arr[0][0];
        int green = arr[0][1];
        int blue = arr[0][2];
        for(int i=1;i<arr.length;i++){
          int  nRed = arr[i][0] + Math.min(green,blue);
           int  nGreen = arr[i][1] + Math.min(red,blue);
           int nBlue = arr[i][2] + Math.min(green,red);
            
            red = nRed;
            green = nGreen;
            blue = nBlue;
        }
        int ans = Math.min(red,Math.min(blue,green));
        System.out.println(ans);
        
    }
}