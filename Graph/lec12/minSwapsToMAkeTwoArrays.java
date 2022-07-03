// ----------- Minimum swaps to make two arrays consisting unique elements identical ------------------
// --------------------------------- GFG ----------------------------------------------------



import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		int[] a  = {3, 6, 4, 8};
		int[] b = {4, 6, 8, 3};
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < b.length; i++){
		    map.put(b[i], i);
		}
		
		int ans = 0;
		boolean[] vis = new boolean[a.length];
		for(int i = 0; i < a.length; i++){
		    if(vis[i] == true || map.get(a[i]) == i){
		        continue;
		    }
		    
		    vis[i] = true;
		    int j = i;
		    int cs = 0;
		    do {
		        j = map.get(a[j]);
		        vis[j] = true;
		        cs++;
		    } while(j != i);
		    
		    ans += (cs - 1);
		}
		
		System.out.println(ans);
	}
}