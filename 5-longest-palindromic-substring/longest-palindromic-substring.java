class Solution {
    Boolean dp[][];
    public String longestPalindrome(String s) {
        //i can find the smallest palindrome
        // and then build from that 
        //keep track of the width and start position if i find valid palindrome
        if(s.length()==1) return s;
        
        int maxLen = 0;
        int startPos = -1;
        int len = s.length();
        dp = new Boolean[len][len];
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalindrome(i,j,s)){
                    if(j-i+1 >= maxLen){
                        maxLen = j-i+1;
                        startPos=i;
                    }
                }
            }
        }

        return s.substring(startPos, startPos+maxLen);
    }


    private boolean isPalindrome(int start, int end, String s){
        if(start>=end) return true;
        if(dp[start][end]!=null) return dp[start][end];
        if(s.charAt(start) != s.charAt(end)) return dp[start][end] = false;
        return dp[start][end] = isPalindrome(start+1,end-1,s);
    }
}