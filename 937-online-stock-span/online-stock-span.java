class StockSpanner {
    Stack<PriceSpan> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        if(stack.isEmpty()){
            stack.push(new PriceSpan(price, 1));
            return 1;
        }
        else{
            int span = 1;
            while(!stack.isEmpty() && stack.peek().price <= price){
                span += stack.pop().span;
            }
            stack.push(new PriceSpan(price, span));
            return span;
        }
    }
}

class PriceSpan {
    int price;
    int span;
    public PriceSpan(int price, int span){
        this.price = price;
        this.span = span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */