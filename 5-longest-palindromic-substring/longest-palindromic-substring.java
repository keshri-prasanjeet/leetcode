class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0;
        int maxLen = 0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalin(s, i, j) == true){
                    if(j-i+1 > maxLen){
                        start = i;
                        maxLen = j-i+1;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }

    private boolean isPalin(String s, int i, int j){
        if(i>=j) return true;
        if(s.charAt(i) != s.charAt(j)) return false;
        else{
            return isPalin(s, i+1, j-1);
        }
    }
}