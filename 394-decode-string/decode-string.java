class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k * 10 + (ch - '0');
            }
            else if(ch == '['){
                countStack.push(k);
                stringStack.push(currentString);
                k = 0;
                currentString = new StringBuilder();
            }
            else if(ch == ']'){
                int count = countStack.pop();
                StringBuilder outsideString = stringStack.pop();
                while(count-- > 0){
                    outsideString.append(currentString);
                }
                currentString = outsideString;
            }
            else currentString.append(ch);
        }
        return currentString.toString();
    }
}