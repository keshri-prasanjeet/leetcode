class Solution {
    Integer[] dp;
    public int numDecodings(String s) {
        //multiple ways to decode
        //there are rules to branching
        //if we reach the end that means we have decoded
        //so do decoded+1
        dp = new Integer[s.length()];
        return countDecodings(s, 0, s.length());
    }
    private int countDecodings(String s, int idx, int len){
        if(idx == len) return 1;
        char a = s.charAt(idx);
        if(a == '0') return 0;
        if(dp[idx]!=null) return dp[idx];
        int takeOneCount = 0;
        int takeTwoCount = 0;
        takeOneCount = countDecodings(s, idx+1, len);
        if(idx+1<len && (a == '1' || (a == '2' && (s.charAt(idx+1) - '0' < 7)))){
            takeTwoCount = countDecodings(s, idx+2, len);
        }
        dp[idx] = takeOneCount + takeTwoCount;
        return dp[idx];
    }
}