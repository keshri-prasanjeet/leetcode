class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int first = 0;
        int second = 0;
        for(String token:tokens){
            if(token.equals("*")){
                first = st.pop();
                second= st.pop();
                st.push(first * second);
            }
            else if(token.equals("+")){
                first = st.pop();
                second= st.pop();
                st.push(first + second);
            }
            else if(token.equals("-")){
                first = st.pop();
                second= st.pop();
                st.push(second - first);
            }
            else if(token.equals("/")){
                first = st.pop();
                second= st.pop();
                st.push(second / first);
            }
            else{
                st.push(Integer.valueOf(token));
            }
        }
        return st.pop();
    }
}