// Pair Approach 

// class Solution {
//     class Pair implements Comparable<Pair> {
//         int time;
//         int delta;
//         Pair(int time, int delta){
//             this.time = time;
//             this.delta = delta;
//         }
//         public int compareTo(Pair o){
//             if(this.time != o.time){
//                 return this.time - o.time;
//             } else {
//                 if(this.delta < 0){
//                     return -1;
//                 } else if(o.delta < 0){
//                     return +1;
//                 } else {
//                     return 0;
//                 }
//             }
//         }
//     }
//     public boolean carPooling(int[][] trips, int capacity) {
//         int[] map = new int[1001];
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//         for(int[] trip: trips){
//             pq.add(new Pair(trip[1], +trip[0]));
//             pq.add(new Pair(trip[2], -trip[0]));
//         }
//         int pic = 0;  // pic-> passenger in car
//         while(pq.size() > 0){
//             Pair rem = pq.remove();
//             pic += rem.delta;
            
//             if(pic > capacity){
//                 return false;
//             } else if(pic < 0){
//                 pic = 0;
//             }
//         }
//         return true;
//     }
// }



// HashMap Approach



class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> stops = new ArrayList<>(); 
        for(int[] trip: trips){
            int people = trip[0];
            int from   = trip[1];
            int to     = trip[2];
            if(map.containsKey(from) == false){
                map.put(from, +people);
                stops.add(from);
            } else {
                map.put(from, map.get(from) + people);
            }
            if(map.containsKey(to) == false){
                map.put(to, -people);
                stops.add(to);
            } else {
                map.put(to, map.get(to) - people);
            }
        }
        Collections.sort(stops);
        int pic = 0;
        for(int stop: stops){
            int delta = map.get(stop);
            pic += delta;
            
            if(pic > capacity){
                return false;
            }
        }
        return true;
    }
}



// Using Array Approach
// class Solution {
//     public boolean carPooling(int[][] trips, int capacity) {
//         // Because from and to is between 0 and 1000. Idea is to store counts in an array of size 1001.
//         int lengthOfTrip[] = new int[1001];
//         for (int trip[] : trips){
//             lengthOfTrip[trip[1]] += trip[0]; // Increment when passenger is on board
//             lengthOfTrip[trip[2]] -= trip[0]; // decrement when they depart
//         }
// 		// Count total passenger for each bus top
//         int carLoad = 0;
//         // we have the count array, we perform a line sweep from 0 to 1000 and track its total
//         for (int i = 0; i < 1001; i++){
//             carLoad += lengthOfTrip[i];
// 			// Reject when the car is overloaded somewhere
//             if(carLoad > capacity){
//                  return false;
//             }
//         }
//         return true; // Accept only if all trip is safe
//     }
// }


// TreeSet Approach 


// T(C) -> O(nlogn)
// class Solution {
//     public boolean carPooling(int[][] trips, int capacity) {
//         TreeMap<Integer, Integer> m = new TreeMap<>();
//         for (int[] v: trips){
//             int num_passengers = v[0];
//             int start = v[1];
//             int end = v[2];
//             m.put(start, m.getOrDefault(start, 0) + num_passengers); // baith rha h toh add kia pass
//             m.put(end, m.getOrDefault(end, 0) - num_passengers); // utrega rha h toh minus kia pass
//         }
//         int count=0;
//         for (int c: m.values()){
//             count+=c;
//             if(count>capacity) return false;
//         }
//         return true;
//     }
// }