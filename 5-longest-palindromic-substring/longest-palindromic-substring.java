class Solution {
    Boolean dp[][];
    public String longestPalindrome(String s) {
        int maxPalinLen = 0;
        int start = -1;

        int len = s.length();
        dp = new Boolean[len][len];
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalindrome(i,j,s)){
                    if(j-i+1 > maxPalinLen){
                        start = i;
                        maxPalinLen = j-i+1;
                    }
                }
            }
        }
        return s.substring(start, start+maxPalinLen);
    }

    private boolean isPalindrome(int start, int end, String s){
        if(start >= end) return true;
        if(dp[start][end] != null) return dp[start][end];
        if(s.charAt(start)!=s.charAt(end)){
            dp[start][end] = false;
            return false;
        }
        return dp[start][end] = isPalindrome(start+1, end-1, s);
    }
}