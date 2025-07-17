class Solution {
    Integer dp[];
    public int numDecodings(String s) {
        //we wil follow the logic of take one, take two
        int len = s.length();
        dp = new Integer[len];
        return decodeWays(s, 0);
    }

    private int decodeWays(String s, int index){
        if(index == s.length()) return 1;
        if(s.charAt(index)== '0') return 0;
        if(dp[index]!=null) return dp[index];
        int takeOneNum = 0;
        int takeTwoNum = 0;

        takeOneNum = decodeWays(s, index+1);

        if(index + 1 < s.length()){
            if(s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index+1)-'0' <= 6)){
                takeTwoNum = decodeWays(s, index+2);
            }
        }

        return dp[index] = takeOneNum + takeTwoNum;
    }
}