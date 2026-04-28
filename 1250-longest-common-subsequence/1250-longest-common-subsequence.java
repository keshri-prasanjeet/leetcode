class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1][len2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findLCE(dp, text1, text2, 0, 0);
    }

    private int findLCE(int[][] dp, String text1, String text2, int i, int j){
        if(i==text1.length() || j==text2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int res = 0;
        if(text1.charAt(i)==text2.charAt(j)){
            res = 1+ findLCE(dp, text1, text2, i+1, j+1);
        }
        else{
            res = Math.max(
                findLCE(dp, text1, text2, i+1, j),
                findLCE(dp, text1, text2, i, j+1)
            );
        }
        return dp[i][j] = res;
    }
}