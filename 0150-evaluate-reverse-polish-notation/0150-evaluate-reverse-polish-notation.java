class Solution {
    public int evalRPN(String[] tokens) {
        //reverse polish notation
        //operands has to be popped
        //when we see an operator use it do the arithmetic operation
        //now store that number as the first "popped" number

        Stack<Integer> tokenStack = new Stack<>();
        for(String token: tokens){
            try{
                int num = Integer.parseInt(token);
                tokenStack.push(num);
            }
            catch(Exception e){
                char[] operator = token.toCharArray();
                int first = tokenStack.pop();
                int second = tokenStack.pop();
                if(operator[0] == '+'){
                    tokenStack.push(second+first);
                }
                else if(operator[0] == '-'){
                    tokenStack.push(second-first);
                }
                else if(operator[0] == '*'){
                    tokenStack.push(second*first);
                }
                else{
                    tokenStack.push(second/first);
                }
            }
        }
        return tokenStack.pop();
    }
}