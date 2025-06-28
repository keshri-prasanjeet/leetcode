class MinStack {

    Stack<Pair> st;

    public MinStack() {
        st = new Stack<Pair>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val, val));
        }
        else{
            int curMin = st.peek().minVal;
            curMin = Math.min(curMin, val);
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
        return st.peek().minVal;
    }
}

class Pair{
    int val;
    int minVal;

    public Pair(int val, int minVal){
        this.val = val;
        this.minVal = minVal;
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