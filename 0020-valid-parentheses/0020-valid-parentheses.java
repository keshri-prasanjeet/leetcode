class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> pairs = Map.of(')','(','}','{',']','[');
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(pairs.containsValue(c)){
                stack.push(c);
            }
            else if(pairs.containsKey(c)){
                if(stack.isEmpty() || stack.pop() != pairs.get(c)) return false;
            }
        }
        return stack.isEmpty();
    }
}