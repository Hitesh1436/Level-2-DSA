class Solution {
    public int maximumSwap(int num) {
        char[] arr = (num + "").toCharArray();// number to char array conversion
        int[] right = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            if(i == arr.length - 1){
                right[i] = -1;  // agr sbse bdi value last mn h toh uske right mn koi ni h toh -1 daldia right[i]pr
            } else if(i == arr.length - 2){ // second last pr h toh last vle ka idx dldo
                right[i] = arr.length - 1;
            } else {
    // bki phle h toh usse next value compare krenge arr ke right ke i+1 idx vale se
                if(arr[i + 1] > arr[right[i + 1]]){
                    right[i] = i + 1;
                } else {
                    right[i] = right[i + 1]; 
                }
            }
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] < arr[right[i]]){
                // arr of 9 chota h arr of right ke i se toh swap krenge ab
                char temp = arr[i];
                arr[i] = arr[right[i]];
                arr[right[i]] = temp;
                break;
            }
        }
        // last mn parse krdia bas
        return Integer.parseInt(new String(arr));
    }
}


// 2nd Solution

// class Solution {
//     public int maximumSwap(int num) {
//         if(num < 10) return num;
        
//         char[] arr = String.valueOf(num).toCharArray();
        
//         int[] rightIndex = new int[10]; // to hold the last index of each digit     
        
//         for(int i=0; i<arr.length; i++){
//             rightIndex[arr[i] - '0'] = i;  // arr[i] - '0' converts char to num
//         }
        
//         for(int i=0; i<arr.length; i++){  // index of present digit we are looking at
//             for(int j=9; j>arr[i] - '0'; j--){ // max digit could be 9 and min be GREATER than the present digit we looking at
//                 if(rightIndex[j] > i){  // if index of 'j' (starts with 9) is greater than present index (basically, is the bigger digit at RIGHT of present digit)
//                     // swap and return the answer
//                     char temp = arr[i];
//                     arr[i] = arr[rightIndex[j]];
//                     arr[rightIndex[j]] = temp;
//                     return Integer.valueOf(new String(arr)); // return here 
//                 }
//             }
//         }
        
// 		// if we reach till here, that means no swapping is required in the input number.
//         return num;
//     }
// }

// HashMap Solution
// class Solution {
//     public int maximumSwap(int num) {
//         String str = Integer.toString(num);
//         char[] ch = str.toCharArray();
//         Map<Integer, Integer> map = new HashMap<>();
        
//         int maxI = ch.length-1, max = ch[maxI]-'0'; 
//         for(int i = ch.length-2; i >= 0; i--){
//             int tmp = ch[i]-'0';
//             if(tmp < max)
//                 map.put(i, maxI);
//             else if(tmp > max){
//                 maxI = i;
//                 max = tmp;
//             }
//         }
        
//         for(int i = 0; i < ch.length-1; i++){
//             if(map.containsKey(i)){
//                 swap(ch, i, map.get(i));
//                 break;
//             }
//         }
        
//         str = new String(ch);
//         return Integer.parseInt(str);
//     }
    
//     void swap(char[] ch, int a, int b){
//         char tmp = ch[a];
//         ch[a] = ch[b];
//         ch[b] = tmp;
//     }
// }
