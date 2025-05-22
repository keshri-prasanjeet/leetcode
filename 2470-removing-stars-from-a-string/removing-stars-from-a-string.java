class Solution {
    public String removeStars(String s) {
        // Stack<Character> stack = new Stack<>();
        Deque<Character> stack = new ArrayDeque<>();
        for(char a: s.toCharArray()){
            if(a != '*'){
                stack.push(a);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}