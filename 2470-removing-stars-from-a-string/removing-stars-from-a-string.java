class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch != '*') st.push(ch);
            else{
                if(!st.isEmpty()) st.pop();
            }
        }
        return st.stream().map(c -> String.valueOf(c)).collect(Collectors.joining());
    }
}