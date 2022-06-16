// Without using Comparable class  and using lambda expression
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   static class triplet{
       // prims ke liye triplet
       int s;  // source
       int p;  // parent 
       int cost ; // cost
       triplet(int s,int p,int cost){
           this.s = s;
           this.p = p;
           this.cost = cost;
       }
   }
   
   public static void minWire(ArrayList<Edge> []graph){
       int n = graph.length;
       PriorityQueue<triplet> pq = new PriorityQueue<>((a,b)->{
           return a.cost- b.cost;             // yh pq ko cost ke basis pr dega hume inc. 
       });
       boolean []vis = new boolean[n];
       //seeding
       pq.add(new triplet(0,-1,0));
       while(pq.size()!=0){
           // remove
           triplet rem = pq.remove();
           // work 
           if(vis[rem.s]==false && rem.p !=-1){
               System.out.println("["+rem.s + "-" + rem.p + "@" +rem.cost+"]");
           }  
           // mark
           vis[rem.s]=true;
           
           //add
           for(Edge e : graph[rem.s]){
               int nbr = e.nbr;
               if(!vis[nbr]){
                   pq.add(new triplet(nbr,rem.s,e.wt));
               }
           }
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }
      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
      minWire(graph);
   }
}



// with using Comparable class

// import java.io.*;
// import java.util.*;

// public class Main {
//    static class Edge {
//       int src;
//       int nbr;
//       int wt;

//       Edge(int src, int nbr, int wt) {
//          this.src = src;
//          this.nbr = nbr;
//          this.wt = wt;
//       }
//    }

//    public static void main(String[] args) throws Exception {
//       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//       int vtces = Integer.parseInt(br.readLine());
//       ArrayList<Edge>[] graph = new ArrayList[vtces];
//       for (int i = 0; i < vtces; i++) {
//          graph[i] = new ArrayList<>();
//       }

//       int edges = Integer.parseInt(br.readLine());
//       for (int i = 0; i < edges; i++) {
//          String[] parts = br.readLine().split(" ");
//          int v1 = Integer.parseInt(parts[0]);
//          int v2 = Integer.parseInt(parts[1]);
//          int wt = Integer.parseInt(parts[2]);
//          graph[v1].add(new Edge(v1, v2, wt));
//          graph[v2].add(new Edge(v2, v1, wt));
//       }
      
//       int src = 0;
//       PriorityQueue<Pair> pq = new PriorityQueue<>();
//       pq.add(new Pair(src,-1,0));
//       Integer []vis = new Integer[vtces];
//       while(pq.size()>0){
//           Pair rem = pq.remove();
//           if(vis[rem.v] != null){
//               continue;
//           }
//           vis[rem.v] = rem.p;
//           if(rem.p != -1){
//               System.out.println("[" + rem.v + "-" + rem.p + "@" + rem.wt + "]");
//           }
//           for(Edge e: graph[rem.v]){
//               if(vis[e.nbr] == null){
//                   pq.add(new Pair(e.nbr,rem.v,e.wt));
//               }
//           }
//       }
//    }
//    static class Pair implements Comparable<Pair>{
//           Integer v; 
//           Integer p;
//           int wt;
          
//           Pair(Integer v,Integer p,int wt){
//               this.v = v;
//               this.p = p;
//               this.wt = wt;
//           }
//           public int compareTo(Pair o){
//               return this.wt - o.wt;
//           }
//       }
// }