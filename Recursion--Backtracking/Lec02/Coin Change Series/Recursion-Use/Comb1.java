// single supply hai
public class Comb1 {
    public static int coinChangeCombSingle(int [] coins, int tar,int idx, String asf){
        if(tar == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i = idx; i<coins.length; i++){
            if(tar - coins[i] >= 0){
                count += coinChangeCombSingle(coins, tar-coins[i],i+1, asf + coins[i]);
            }
        }


        return count;

    }

    public static void main(String [] args){
        int [] coins = {2,3,5,7};
        int tar = 10;
        int ans = coinChangeCombSingle(coins, tar,0, "");
        System.out.println("Count is -> " + ans);
    }
}

