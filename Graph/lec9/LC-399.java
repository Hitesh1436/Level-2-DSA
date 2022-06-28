class Solution {
    HashMap<String,String> parent;
    HashMap<String,Double> mult;
   public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
       parent = new HashMap<>();
       mult = new HashMap<>();
       
       for(List<String>eqn : equations){
        addToDSU(eqn.get(0));
        addToDSU(eqn.get(1));
       }
       
       int i=0;
       for(List<String>eqn : equations){  // l0 -> lead 0,l1 -> lead 1
           String l0 = find(eqn.get(0));
           String l1 = find(eqn.get(1));
           
           if(l0.equals(l1) == false){
               // union -> agr a/b dia h and c/d dia h hume a/c niklna ho toh krenge ese 
               double m0 = mult.get(eqn.get(0));
               double m1 = mult.get(eqn.get(1));
               
               parent.put(l0,l1);
               mult.put(l0,(values[i] * m1)/m0);
           }
           i++;
       }
       double[] ans=new double[queries.size()];
       i =0;
       
       for(List<String> query : queries){
           String q0 = query.get(0);
           String q1 = query.get(1);
           
           if(parent.containsKey(q0)== false || parent.containsKey(q1) == false){
               ans[i] = -1;
               i++;
               continue;
           }
           String l0 = find(q0);
           String l1 = find(q1);
           
           if(l0.equals(l1)== false){
               ans[i] = -1;
               i++;
               continue;
           }
           double m0 = mult.get(q0);
           double m1= mult.get(q1);
               ans[i] = m0/m1;
               i++;
       }
           return ans;
   }
   void addToDSU(String x){
       if(!parent.containsKey(x)){
           parent.put(x,x);
           mult.put(x,1.0);
       }
   }
   String find(String x){
       if(parent.get(x).equals(x)){
           return parent.get(x);
       }else{
           String cp = parent.get(x);  // cp-> current parent
           String fp = find(cp);  // fp -> final parent
           
           parent.put(x,fp);
           mult.put(x,mult.get(cp) * mult.get(x));
           
           return fp;
       }
   }
}