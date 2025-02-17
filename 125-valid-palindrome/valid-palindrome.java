class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        String filteredString = sb.toString().toLowerCase();
        String revFilteredString = sb.reverse().toString().toLowerCase();
        if(filteredString.equals(revFilteredString)) return true;
        return false;
    }
}