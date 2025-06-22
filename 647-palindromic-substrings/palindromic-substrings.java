class Solution {
    Boolean[][] dp;
    public int countSubstrings(String s) {
        //thoughts
        //can start the helper method from each character
        //increase size by one from both sides and continue until
        //characters at both indices are same
        //since palindromic substrings can overlap
        //starting a new substring check for palindrome from each index
        // is okay
        int len = s.length();
        dp = new Boolean[len][len];
        int count = 0;
        for(int i = 0; i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalindrome(s, i, j) == true){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int i, int j){
        if(i>=j) return true;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)!=s.charAt(j)) return false;
        return dp[i][j] = isPalindrome(s, i+1, j-1);
    }
}