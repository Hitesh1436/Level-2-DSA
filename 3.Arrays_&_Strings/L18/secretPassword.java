// ------------------------ CodeChef - --> Chef and Secret Password   -----------



/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef{
	public static void main (String[] args) throws java.lang.Exception{	
	    Scanner scn = new Scanner(System.in);
	    int t = Integer.parseInt(scn.nextLine());
	    
	    while(t-- > 0){
	        int len = Integer.parseInt(scn.nextLine());
	        String s = scn.nextLine();
	        String ans = solve(s);
	        System.out.println(ans);
	    }
	}
	
	public static String solve(String s){
	    int[] Z = getZArray(s);
	    HashMap<Integer, Integer> map = new HashMap<>();
	    for(int val: Z){
	        if(val == 0){
	            continue;
	        }	        
	        for(int v = 1; v <= val; v++){
	            map.put(v, map.getOrDefault(v, 0) + 1);
	        }
	    }        
        int ans = 0;
        int freq = 0;
        for(int key: map.keySet()){
            if(map.get(key) > freq){
                freq = map.get(key);
                ans = key;
            } else if(map.get(key) == freq){
                if(key > ans){
                    ans = key;
                }
            }
        }
        if(ans == 0){
            return s;
        }
        return s.substring(0, ans);
	}
	public static int[] getZArray(String s){
	    int[] Z = new int[s.length()];  // z array bnai hai jiska first hmesha 0 hota h 
	    
	    Z[0] = 0;
	    
	    int l = 0;
	    int r = 0;
	    for(int i = 1; i < s.length(); i++){
	        if(i > r){  // agr bhr nikal jata h toh left and right ko i pr leaao
	            l = r = i;
	            while(r < s.length() && s.charAt(r) == s.charAt(r - l)){  // jbtk right ko bdhaoo jbtk same char milt rhe
	                r++;
	            }	            
	            r--;
	            Z[i] = r - l + 1;  // ans i.e z[i]  mein right - left +1 daldo
	        } else {  // agr i r and l ke bich mn h toh jo z[i] uss vale ke bich vlon ka hoga vo phle vlon jsa hoga  
	            int k = i - l;
	            if(Z[k] < r - i + 1){
	                Z[i] = Z[k];
	            } else {
	                l = i;
    	            while(r < s.length() && s.charAt(r) == s.charAt(r - l)){
    	                r++;
    	            }
    	            r--;
    	            Z[i] = r - l + 1;
	            }
	        }
	    }
	    return Z;
	}
}