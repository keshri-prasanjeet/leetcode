class MinStack {
    Deque<StackData> stack;
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int value) {
        if(stack.isEmpty()){
            stack.push(new StackData(value, value));
        }
        else{
            int newMin = Math.min(value, stack.peek().getMinValue());
            stack.push(new StackData(value, newMin));
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
    }
    
    public int top() {
        
            return stack.peek().getValue();
        
    }
    
    public int getMin() {
        
            return stack.peek().getMinValue();
        
    }
}

class StackData{
    int value;
    int minValue;
    public StackData(int value, int minValue){
        this.value = value;
        this.minValue = minValue;
    }

    public int getValue(){
        return this.value;
    }

    public int getMinValue(){
        return this.minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */