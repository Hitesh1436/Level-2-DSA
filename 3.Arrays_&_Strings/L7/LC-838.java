class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";  // first mn L add krdia and last mn R bas
        int pi = 0;  // previous idx
        char[] arr = dominoes.toCharArray();
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == 'R'){ 
                // L R vala case hoga yh toh mtlb bich vle ko kuch ni hoga
                if(arr[pi] == 'L'){
                    // nothing to do
                } else if(arr[pi] == 'R'){
                    // R R vala case h toh sb right girenge
                    for(int x = pi + 1; x < i; x++){
                        arr[x] = 'R';
                    }
                }
                pi= i;
            } else if(arr[i] == 'L'){
                if(arr[pi] == 'L'){
                    // L L vala case mtlb sab left girenge
                    for(int x = pi + 1; x < i; x++){
                        arr[x] = 'L';
                    }
                } else if(arr[pi] == 'R'){
            // yh h jiske pass vo girao and jhm dono sth phuche usse rhne denge bas
                    int lo = pi + 1;
                    int hi = i - 1;
                    while(lo < hi){
                        arr[lo] = 'R';
                        arr[hi] = 'L';
                        lo++;
                        hi--;
                    }
                }
                pi = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length - 1; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}