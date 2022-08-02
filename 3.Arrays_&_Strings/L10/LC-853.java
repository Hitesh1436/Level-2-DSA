// Using TreeMap 
// class Solution {  T(C) -> O(nlogn)
//     public int carFleet(int target, int[] position, int[] speed) {
//         TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
//         for(int i=0;i<position.length;i++){
//             map.put(position[i],speed[i]);
//         }
//         double time =0;
//         int groups =0;
//         for(Map.Entry<Integer,Integer>car : map.entrySet()){
//             int pos = car.getKey();  // pos -> position
//             int sp = car.getValue(); // sp -> speed
//             int dist = target - pos;
//             double currTime = dist * 1.0 / sp;
//             if(currTime > time){
//                 time = currTime;
//                 groups++;
//             }
//         }
//         return groups;
//     }
// }

// Using Cars Array and Arrays.sort  T(C) -> O(nlogn)

// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//        Car[] cars = new Car[position.length];
//         for(int i=0;i<position.length;i++){
//             cars[i] = new Car(position[i],speed[i]);  
//         }
//         Arrays.sort(cars);
        
//         int groups =0;
//         double time =0;
//         for(int i= cars.length -1;i>=0;i--){
//             Car rem = cars[i];  
//             double cTime = (target -rem.pos)*1.0 /rem.speed;  // cTime -> current time 
//             if(cTime > time){
//                 time = cTime;
//                 groups++;
//             }
//         }
//         return groups;
//     }
//     class Car implements Comparable<Car>{
//         int pos;
//         int speed;
//         Car(int pos,int speed){
//             this.pos = pos;
//             this.speed = speed;
//         }
//         public int compareTo(Car c){
//             return this.pos - c.pos;
//         }
//     }
// }


// PriorityQueue Solution  T(C) -> O(nlogn)

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Car> pq = new PriorityQueue<>();
        for(int i=0;i<position.length;i++){
            Car c = new Car(position[i],speed[i]);
            pq.add(c);
        }
        int groups =0;
        double time =0;
        while(pq.size()>0){
            Car rem = pq.remove();  // cTime -> current time 
            double cTime = (target -rem.pos)*1.0 /rem.speed;
            if(cTime > time){
                time = cTime;
                groups++;
            }
        }
        return groups;
    }
    class Car implements Comparable<Car>{
        int pos;
        int speed;
        Car(int pos,int speed){
            this.pos = pos;
            this.speed = speed;
        }
        public int compareTo(Car c){
            return c.pos - this.pos;
        }
    }
}




// Using Array T(C) -> O(n)

// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         int count = 0;
//        double[] timeArr = new double[target];
//        for (int i = 0; i < position.length; i++){
//             timeArr[position[i]]= (double)(target - position[i]) / speed[i];
//         }
//         double prev = 0.0;
//         for (int i = target-1; i >=0 ; i--){
//             double curr = timeArr[i];
//             if (curr > prev){
//                 prev = curr;
//                 count++;
//             }
//         }
//         return count;  
//     }
// }