// --------------------------------- GFG -----------------------------------

// Class Approach ->

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/

class Solution{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n){
        Arrays.sort(arr,(a,b) ->{
           return b.profit - a.profit;  // decreasing order mn krdia sort humne profit ke basis pr
        });
        parent = new int[101];
        
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        int count =0;
        int profit =0;
        for(Job j : arr){
            int x = j.deadline;
            int empty = find(x);
            
            if(empty>0){
                // job j is done on empty day
                count++;
                profit += j.profit;
                
                parent[empty] = find(empty-1);
            }
        }
        return new int[]{count,profit};
    }
    int []parent;
    int find(int x){
        if(parent[x] ==x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}




// Pair Class Approach ->

// static class Job{
//     int id;
//     int profit;
//     int deadline;
// }
// static int[] JobScheduling(Job arr[], int n){
//     // Your code here
//     Arrays.sort(arr ,(a,b)->{
//         return b.profit-a.profit;
//     });
//     parent = new int[101];
//     for(int i=0; i<parent.length; i++){
//         parent[i]=i;
//     }
//     int ans=0;
//     int count = 0;
//     for(Job job: arr){
//         int lx = find(job.deadline);
//         if(lx>0){
//             count++;
//             ans+=job.profit;
//             parent[lx] = find(lx-1); 
//         }
//     }
    
//     int ret[] ={count, ans};
//     return ret;
// }
// static int parent[];
// static int find(int x){
//     if(parent[x]==x){
//         return x;
//     }else{
//         int temp = find(parent[x]);
//         parent[x] = temp;
//         return temp;
//     }
// }