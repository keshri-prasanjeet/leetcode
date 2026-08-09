class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> tokenStack = new Stack<>();
        for(String token: tokens){
            if(token.length() == 1 && "+-*/".contains(token)){
                int second = tokenStack.pop();
                int first = tokenStack.pop();
                switch(token){
                    case "+" : tokenStack.push(first + second); break;
                    case "-" : tokenStack.push(first - second); break;
                    case "*" : tokenStack.push(first * second); break;
                    case "/" : tokenStack.push(first / second); break;
                }
            }
            else tokenStack.push(Integer.parseInt(token));
        }
        return tokenStack.pop();
    }
}