import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numDistinctIslands(arr));

  }

  public static StringBuilder psf = new StringBuilder();

  public static int numDistinctIslands(int[][] arr) {
    boolean[][]vis = new boolean[arr.length][arr[0].length];
        HashSet<String> unique = new HashSet<>();
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            if(vis[i][j] == false && arr[i][j]==1){
                psf = new StringBuilder();
                traverse(arr,vis,i,j);
                unique.add(psf.toString());
            }
        }
    }
    return unique.size();
  }
  private static void traverse(int[][]arr,boolean[][]vis,int i,int j){
      vis[i][j] = true;
      if(i-1>=0 && arr[i-1][j] == 1 && vis[i-1][j] == false){
          psf.append("N");
          traverse(arr,vis,i-1,j);
      }
      if(j+1<arr[0].length && arr[i][j+1] == 1 && vis[i][j+1] == false){
          psf.append("E");
          traverse(arr,vis,i,j+1);
      }
      if(i+1<arr.length && arr[i+1][j] == 1 && vis[i+1][j] == false){
          psf.append("S");
          traverse(arr,vis,i+1,j);
      }
      if(j-1>=0 && arr[i][j-1] == 1 && vis[i][j-1] == false){
          psf.append("W");
          traverse(arr,vis,i,j-1);
      }
      psf.append("B");
  }
}