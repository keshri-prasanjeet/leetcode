class Solution {
    public boolean isValid(String s) {
        Stack<Character> parenthesesStack = new Stack<>();
        for(char p: s.toCharArray()){
            if(p == '(' || p=='{' || p=='['){
                parenthesesStack.push(p);
            }
            else{
                if(parenthesesStack.isEmpty()) return false;
                if(p==')'){
                    if(parenthesesStack.peek()!='(') return false;
                    else parenthesesStack.pop();
                }
                else if(p=='}'){
                    if(parenthesesStack.peek()!='{') return false;
                    else parenthesesStack.pop();
                }
                else{
                    if(parenthesesStack.peek()!='[') return false;
                    else parenthesesStack.pop();
                }
            }
        }
        if(!parenthesesStack.isEmpty()) return false;
        return true;
    }
}