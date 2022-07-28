class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        ArrayList<Integer> al=new ArrayList<>();
        boolean isprime[]=new boolean[N+1];
        Arrays.fill(isprime,true);
        
        for(int i=2;i*i<=N;i++){
            if(isprime[i]){
                for(int j=2*i;j<=N;j=j+i){
                    isprime[j]=false;
                }
            }
        }
        for (int i=2;i<=N;i++){
            if(isprime[i]==true){
                al.add(i);
            }
        }
        return al;
    }
 }