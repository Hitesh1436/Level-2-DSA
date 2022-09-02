public class floodFill {

    public static boolean inRange(int i, int j, int [][] arr){
        int n = arr.length;
        int m = arr[0].length;

        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }

    public static boolean inRange(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }
    public static int floodFill_01(int sr, int sc, int dr, int dc, boolean [][] vis,  int [][] dir, String [] dirN, String asf){
        if(sr == dr && sc == dc){
            System.out.println(asf);
            return 1;
        }
        vis[sr][sc] = true;
        int count  = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(inRange(r,c,dr + 1, dc + 1) && !vis[r][c]){
                count += floodFill_01(r,c, dr, dc,vis, dir, dirN, asf + dirN[d]);
            }
        }
        vis[sr][sc] = false;
        return count;

    }

    public static void floodFill(){
        int n = 3;
        int m = 3;
        String [] dirN = {"A", "B", "C", "D", "E", "F", "G", "H"};
        int [][] dir = {{-1, -1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};

        boolean [][] vis = new boolean[n][m];
        
        int ans = floodFill_01(0,0,n-1,m-1,vis, dir, dirN, "");
        System.out.println(ans);
    }

    public static void main(String [] args){
        floodFill();
    }
}
