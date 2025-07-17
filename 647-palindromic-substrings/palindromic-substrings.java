class Solution {
    Boolean[][] dp;
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;
        dp = new Boolean[len][len];
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalin(i,j,s)){
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isPalin(int start, int end, String s){
        if(start >= end) return true;
        if(dp[start][end]!=null) return dp[start][end];
        if(s.charAt(start)!=s.charAt(end)){
            return dp[start][end] = false;
        }
        return dp[start][end] = isPalin(start+1, end-1, s);
    }
}