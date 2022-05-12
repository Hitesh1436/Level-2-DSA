// infinite supply hai
public class Comb2 {
    public static int coinChangeCombInf(int [] coins, int tar,int idx, String asf){
        if(tar == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i = idx; i<coins.length; i++){
            if(tar - coins[i] >= 0){
                count += coinChangeCombInf(coins, tar-coins[i],i, asf + coins[i]);
            }
        }


        return count;

    }

    public static void main(String [] args){
        int [] coins = {2,3,5,7};
        int tar = 10;
        int ans = coinChangeCombInf(coins, tar,0, "");
        System.out.println("Count is -> " + ans);
    }
}

