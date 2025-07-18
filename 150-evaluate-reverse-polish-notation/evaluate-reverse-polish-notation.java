class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens){
            if(Set.of("+","-","*","/").contains(token)){
                int first = st.pop();
                int second= st.pop();
                // System.out.println(first + " " + second);
                if(token.equals("+")) st.push(first + second);
                else if(token.equals("-")) st.push(second - first);
                else if(token.equals("*")) st.push(second * first);
                else st.push(second/first);
            }
            else st.push(Integer.parseInt(token));
        }
        return st.pop();
    }
}