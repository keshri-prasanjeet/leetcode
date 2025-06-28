class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int first = 0;
        int second = 0;
        for(String token: tokens){
            if(token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/")){
                first = st.pop();
                second= st.pop();
                System.out.println(first + " " + second);
                if(token.equals("+")) st.push(first + second);
                else if(token.equals("-")) st.push(second - first);
                else if(token.equals("*")) st.push(second * first);
                else st.push(second/first);
            }
            else st.push(Integer.valueOf(token));
        }
        return st.pop();
    }
}