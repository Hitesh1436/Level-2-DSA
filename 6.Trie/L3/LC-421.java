class Solution {
    class Node{
        Node []children = new Node[2];  // bcz ya toh 0 ya 1 ki side jaskte hn bas
    }
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for(int num : nums){
            Node temp = root;
            for(int i=30 ;i>=0 ;i--){
// yh check krne ke kaam ayga ki ith bit on hai ya off
// 1st bit krni  toh AND krdo this 01000 to that and check kr 1 ayga toh on , 0 toh off
                int bit = (num & (1 << i)) == 0 ? 0 : 1;
                if(temp.children[bit] == null){
                    temp.children[bit] = new Node();
                }
                temp = temp.children[bit];
            }
        }
        int res = 0;
        for(int num : nums){
            int max_xor = 0;
            Node temp = root;
            
            for(int i=30 ;i>=0 ;i--){
                int bit = (num & (1 << i)) == 0 ? 0 : 1;
                int cbit = Math.abs(bit -1); // cbit -> complimentary bit
                
                if(temp.children[cbit] != null){
                    temp = temp.children[cbit];
                    max_xor = max_xor | (1 << i);
                }else{
                    temp = temp.children[bit];
                }
            }
            res = Math.max(res,max_xor);
        }
        return res;
    }
}