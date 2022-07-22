// Sir'r Own Approach -> travelling single diagonal and string them in a list than sorting them and then again putting them in same diagonal
                                                    // T(C) -> O(mnlog(min(m,n)))
// class Solution {
//     public int[][] diagonalSort(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
        
//         for(int gap = -(m - 1); gap <= (n - 1); gap++){
//             ArrayList<Integer> diag = new ArrayList<>();
//             int i = gap < 0? -gap: 0;
//             int j = gap < 0? 0: gap;
//             while(i < m && j < n){
//                 diag.add(mat[i][j]);
//                 i++;
//                 j++;
//             }
            
//             Collections.sort(diag);
//             i = gap < 0? -gap: 0;
//             j = gap < 0? 0: gap;
//             int idx = 0;
//             while(i < m && j < n){
//                 mat[i][j] = diag.get(idx);
//                 idx++;
//                 i++;
//                 j++;
//             }
//         }
        
//         return mat;
//     }
// }


// Using Hashmap Approach   -> T(C) -> O(mnlog(min(m,n)))

class Solution {
    public int[][] diagonalSort(int[][] mat) {
    HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int gap = i-j;
                
                if(map.containsKey(gap)==false){
                    map.put(gap,new PriorityQueue<>());
                }
                map.get(gap).add(mat[i][j]);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int gap = i-j;
               mat[i][j] = map.get(gap).remove();
            }
        }
        return mat;
    }
}


// Count Sort Approach
// class Solution {
//     public int[][] diagonalSort(int[][] mat) {	
//     int m = mat.length;		
//     int n = mat[0].length;		
// 	//start from top right to top left and sort each diagonal
//     for(int i = n-1;i>=0;i--){
//         sort(0,i,m,n,mat);
//     }
// 	//then start from top left to bottom left and sort each diagonal
//     for(int i = 1;i<m;i++){
//         sort(i,0,m,n,mat);
//     }
//     return mat;
// }
// void sort(int x, int y, int rows, int cols, int[][] mat){
// 	//count sort implementation
//     int[] arr = new int[101];
//     int s= x,e= y;
// 	//store the value of each diagonal element in arr
//     while(x < rows && y < cols){
//         arr[mat[x][y]]++;
//         x++;
//         y++;
//     }
//     //write sorted value to each diagonal element
//     for(int i = 0;i<arr.length;){
//         if(arr[i] <= 0){
//             i++;
//             continue;
//         }
//         if(arr[i] > 1){
//             mat[s++][e++] = i;      
//             arr[i]--;
//         }
//         else{
//             mat[s++][e++] = i++;
//         }  
//     } 
//   }
// }



// Recursive Approach \

// class Solution {
//     public int[][] diagonalSort(int[][] mat) {
//         PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//         for(int i =0;i<mat[0].length;i++){
//             helper(mat,0,i,queue);
//         }
//         for(int i = 1;i<mat.length;i++){
//             helper(mat,i,0,queue);
//         }
//         return mat;
//     }
//     public void helper(int[][] mat, int i, int j, PriorityQueue<Integer> queue){
//         if(i<0 || j <0 || i>= mat.length || j >= mat[i].length){
//             return;
//         }
//         queue.add(mat[i][j]);
//         helper(mat,i+1,j+1,queue);
//         mat[i][j] = queue.remove();
//     }
// }