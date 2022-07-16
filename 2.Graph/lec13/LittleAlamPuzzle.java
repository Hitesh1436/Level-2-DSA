// ------------------ CodeForce's -------------------------------


import java.util.*;
import java.io.*;
 
public class Main{
    
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        
        while(t-- >0){
        int n = scn.nextInt();
        
        int []r1 = new int[n];
        int []r2 = new int[n];
        
            for(int i=0;i<n;i++){
                r1[i] = scn.nextInt();
            }
            for(int i=0;i<n;i++){
                r2[i] = scn.nextInt();
            }
            solve(r1,r2);
        }
    } 
    public static void solve(int []r1,int []r2){
        parent = new int[r1.length];
        rank = new int[r1.length];
        
        for(int i=0;i<parent.length;i++){
            parent[i] =i;
            rank[i] =0;
        }
        HashMap<Integer,Integer> m1 = new HashMap<>();
        HashMap<Integer,Integer> m2 = new HashMap<>();
        
        for(int i=0;i<r1.length;i++){
            m1.put(r1[i],i);
        }
         for(int i=0;i<r2.length;i++){
            m2.put(r2[i],i);
        }
        for(int i=0;i<r1.length;i++){
            int iLead = find(i);
            
            int x = m2.get(r1[i]);
            int xLead = find(x);
            if(iLead != xLead){
                union(iLead,xLead);
            }
            int y = m1.get(r2[i]);
            int yLead = find(y);
            if(iLead != yLead){
                union(iLead,yLead);
            }
        }
        int count =0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==i){
                count++;
            }
        }
        int mod = 1000000007;
        int ans =1;
        for(int i=1;i<=count;i++){
            ans = ((ans%mod)*(2%mod))%mod;
        }
        System.out.println(ans);
    }
    static int[]parent;
    static int[]rank;
    
    static int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    static void union(int x,int y){
        if(rank[x]<rank[y]){
            parent[x]=y;
        }else{
            parent[y] =x;
            if(rank[x] == rank[y]){
                rank[x]++;
            }
        }
    }
}