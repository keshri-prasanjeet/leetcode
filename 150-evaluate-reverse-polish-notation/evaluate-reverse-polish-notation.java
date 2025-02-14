class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token:tokens){
            if(token.equals("*")){
                int first = st.pop();
                int second= st.pop();
                first = first * second;
                st.push(first);
            }
            else if(token.equals("+")){
                int first = st.pop();
                int second= st.pop();
                first = first + second;
                st.push(first);
            }
            else if(token.equals("-")){
                int first = st.pop();
                int second= st.pop();
                first = second - first;
                st.push(first);
            }
            else if(token.equals("/")){
                int first = st.pop();
                int second= st.pop();
                first = second / first;
                st.push(first);
            }
            else{
                st.push(Integer.valueOf(token));
            }
        }
        return st.pop();
    }
}