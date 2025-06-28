class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char a: s.toCharArray()){
            if(a == '(' || a == '{' || a == '['){
                st.push(a);
            }
            else{
                if(st.isEmpty()) return false;
                char top = st.peek();
                if((a == ')' && top == '(') ||
                    (a == '}' && top == '{') ||
                    (a == ']' && top == '[')){
                        st.pop();
                }
                else return false;
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}