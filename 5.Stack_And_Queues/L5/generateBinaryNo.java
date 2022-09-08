// -------------GFG ->  Generate Binary Numbers


class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N){
        ArrayList<String> ans = new ArrayList<>();
        LinkedList<String>qu = new LinkedList<String>();
        qu.add("1");
        int i =1;
        while(i<=N){
            String rem = qu.removeFirst();
            ans.add(rem);
            qu.addLast(rem + "0");
            qu.addLast(rem + "1");
            i++;
        }
        return ans;
    }
    
}