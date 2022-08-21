// ------------- GFG - > Wiggle Sort krna h

class Solution {
    public static void convertToWave(int n, int[] a) {
       for(int i=0;i<a.length;i+=2){
           if(i < a.length -1){
               int temp = a[i+1];
               a[i+1] = a[i];
               a[i] = temp;
           }
       }
        
    }
}