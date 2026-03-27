class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 1) return s;
        int maxLen = Integer.MIN_VALUE;
        int subStart = -1;
        int subEnd = -1;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalindrome(i, j, s)){
                    if(maxLen < (j-i+1)){
                        subStart = i;
                        subEnd = j;
                        maxLen = j-i+1;
                    }
                }
            }
        }
        return s.substring(subStart, subEnd+1);
    }

    private boolean isPalindrome(int start, int end, String s){
        if(start >= end) return true;
        if(s.charAt(start)!=s.charAt(end)) return false;
        return isPalindrome(start+1,end-1,s);
    }
}