public class Per1 {
    // single times usage h coins ki
    public static int coinChangePermSingle(int [] coins, int tar, String asf){
        if(tar == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i = 0; i<coins.length; i++){
            if(coins[i]>0 && tar - coins[i] >= 0){
                int val = coins[i];
                coins[i] = -coins[i];   // mark
                count += coinChangePermSingle(coins, tar-val, asf + val);
                coins[i] = -coins[i];   // unmark
            }
        }


        return count;

    }

    public static void main(String [] args){
        int [] coins = {2,3,5,7};
        int tar = 10;
        int ans = coinChangePermSingle(coins, tar, "");
        System.out.println("Count is -> " + ans);
    }
}
