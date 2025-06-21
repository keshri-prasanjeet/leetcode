class Solution {
    Boolean dp[][];
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = Integer.MIN_VALUE;
        int start = Integer.MIN_VALUE;
        dp = new Boolean[len][len];
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalindrome(i, j, s) == true){
                    if(j-i+1 > maxLen){
                        start = i;
                        maxLen = j-i+1;
                    }
                }
            }
        }

        return s.substring(start, start+maxLen);
    }

    private Boolean isPalindrome(int i, int j, String s){
        if(i>=j) return true;
        if(dp[i][j]!= null) return dp[i][j];
        if(s.charAt(i) != s.charAt(j)) return dp[i][j] = false;
        return dp[i][j] = isPalindrome(i+1, j-1, s);
    }
}