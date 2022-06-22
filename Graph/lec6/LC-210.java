class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] req: prerequisites){
            graph[req[0]].add(req[1]);
        }
        int[] in = new int[numCourses];
        for(int v = 0; v < graph.length; v++){
            for(int n: graph[v]){
                in[n]++;
            }
        } 
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int v = 0; v < graph.length; v++){
            if(in[v] == 0){
                queue.add(v);
            }
        }
        int[] ans = new int[graph.length];
        int idx = ans.length - 1;
        while(queue.size() > 0){
            int rem = queue.remove();
            ans[idx] = rem;
            idx--;
            
            for(int n: graph[rem]){
                in[n]--;
                
                if(in[n] == 0){
                    queue.add(n);
                }
            }
        }
        if(idx == -1){
            return ans;
        } else {
            return new int[] {};
        }
    }
}



//-----------------------------  Sir's Previous Solution
// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         int[] ans = new int[numCourses];
        
//         int[] in = new int[numCourses];
//         for(int[] edge: prerequisites){
//             in[edge[1]]++;
//         }
//         ArrayDeque<Integer> queue = new ArrayDeque<>();
//         for(int course = 0; course < numCourses; course++){
//             if(in[course] == 0){
//                 queue.add(course);
//             }
//         }
//         int idx = ans.length - 1;
//         while(queue.size() > 0){
//             int course = queue.remove();
//             ans[idx--] = course;
            
//             for(int[] edge: prerequisites){
//                 if(edge[0] == course){
//                     in[edge[1]]--;
                    
//                     if(in[edge[1]] == 0){
//                         queue.add(edge[1]);
//                     }
//                 }
//             }
//         }
//         if(idx != -1){
//             return new int[]{};
//         }
//         return ans;
//     }
// }