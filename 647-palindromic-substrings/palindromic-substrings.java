class Solution {
    Boolean[][] dp;
    public int countSubstrings(String s) {
        int len = s.length();
        dp = new Boolean[len][len];
        int count = 0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalind(s, i, j)==true) count++;
            }
        }
        return count;
    }

    private boolean isPalind(String s, int i , int j){
        if(i>=j) return true;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i)!=s.charAt(j)) return dp[i][j] = false;
        else{
            return dp[i][j] = isPalind(s, i+1, j-1);
        }
    }
}