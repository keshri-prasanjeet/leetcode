class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> numberStack = new ArrayDeque<>();
        for(String token:tokens){
            if(token.length()==1 && "+-*/".contains(token)){
                //this is an operator
                int first = numberStack.pop();
                int second= numberStack.pop();
                int answer = 0;
                switch(token) {
                    case "+" -> answer = first + second;
                    case "-" -> answer = second - first;
                    case "*" -> answer = first * second;
                    case "/" -> answer = second / first;
                }
                numberStack.push(answer);
            }
            else numberStack.push(Integer.parseInt(token));
        }
        return numberStack.pop();
    }
}