class Pair {
    int val;
    int curMin;
    Pair(int val, int curMin){
        this.val = val;
        this.curMin = curMin;
    }
}

class MinStack {

    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
        }
        else{
            int curMin = st.peek().curMin;
            curMin = curMin<=val?curMin:val;
            st.push(new Pair(val, curMin));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        // if(st.isEmpty()) return 0;
        return st.peek().curMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */