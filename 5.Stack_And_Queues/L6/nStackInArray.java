// ------------------- GFG -> N Stacks In An Array

import java.util.* ;
import java.io.*; 
public class NStack {
    // Initialize your data structure.
    int[] arr;
    int[] next;
    int[] top;
    int free;
    
    public NStack(int N, int S) {
        arr = new int[S];
        next = new int[S];
        top = new int[N + 1];
        free = 0;
        
        for(int i = 0; i < next.length - 1; i++){
            next[i] = i + 1;
        }
        next[next.length - 1] = -1;
        
        for(int i = 0; i < top.length; i++){
            top[i] = -1;
        }
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        if(free == -1){
            return false;
        }
        // capture the spot
        int curr = free;
        
        // remove from free
        free = next[curr];
        
        // add to current
        next[curr] = top[m];
        top[m] = curr;
        
        // receive value
        arr[curr] = x;
        
        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        if(top[m] == -1){
            return -1;
        }
        int curr = top[m];
        
        // remove from stack
        top[m] = next[curr];
        
        // add to free
        next[curr] = free;
        free = curr;
        
        // return
        return arr[curr];
    }
}