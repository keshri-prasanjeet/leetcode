class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder stripped = new StringBuilder();
        for(char a: s.toCharArray()){
            if(Character.isLetterOrDigit(a)){
                stripped.append(Character.toLowerCase(a));
            }
        }
        // String straight = stripped.toString();
        return stripped.toString().equals(stripped.reverse().toString());
    }
}