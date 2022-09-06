// ---------- GFG -> Reverse First K elements of Queue


class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        int sz = q.size();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < k; i++){
            st.push(q.remove());
        }
        while(st.size() > 0){
            q.add(st.pop());
        }
        for(int i = 0; i  < sz - k; i++){
            q.add(q.remove());
        }
        return q;
    }
}
