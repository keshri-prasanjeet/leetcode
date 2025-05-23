class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // handle multi-digit numbers
            } else if (ch == '[') {
                countStack.push(k); // push repeat count
                stringStack.push(currentString); // push current string so far
                currentString = new StringBuilder(); // start fresh
                k = 0;
            } else if (ch == ']') {
                int count = countStack.pop();
                StringBuilder decoded = new StringBuilder(stringStack.pop());
                for (int i = 0; i < count; i++) {
                    decoded.append(currentString);
                }
                currentString = decoded; // updated result so far
            } else {
                currentString.append(ch); // building string
            }
        }

        return currentString.toString();
    }
}
