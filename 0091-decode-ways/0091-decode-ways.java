class Solution {
    Integer[] dp;
    public int numDecodings(String s) {
        //decode the message
        dp = new Integer[s.length()];
        return countAllDecodings(s, 0, s.length());
    }

    private int countAllDecodings(String s, int idx, int len){
        // System.out.println("The idx is " + idx + " and the len is " + len);
        if(idx == len) return 1;
        if(idx > len) return 0;
        if(s.charAt(idx) == '0') return 0;
        if(dp[idx]!=null) return dp[idx];
        int totalDecodeWays = 0;
        totalDecodeWays += countAllDecodings(s, idx+1, len);
        // System.out.println("Took single char and idx is " + idx);
        int cur = s.charAt(idx) - '0';
        if(cur == 1 || (cur == 2 && idx+1<len && s.charAt(idx+1)-'0' < 7)){
            totalDecodeWays += countAllDecodings(s, idx+2, len);
        }
        return dp[idx] = totalDecodeWays;
    }
}