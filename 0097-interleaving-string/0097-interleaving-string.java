class Solution {
    Boolean [][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        //interleaving string means s3 has to be formed with
        //serial components of s1 and s2
        //using all of them
        dp = new Boolean[s1.length()+1][s2.length()+1];
        if(s1.length() + s2.length() != s3.length()) return false;
        return findInterleave(s1, s2, s3, 0, 0);
    }

    private boolean findInterleave(String s1, String s2, String s3, int i, int j){
        if(dp[i][j]!=null) return dp[i][j];
        if(i==s1.length() && j==s2.length()) return dp[i][j] = true;
        boolean canInterleave = false;
        int idx = i + j;
        if(i < s1.length() && s3.charAt(idx) == s1.charAt(i)){
            canInterleave = findInterleave(s1, s2, s3, i+1, j);
        }
        if(!canInterleave && j < s2.length() && s3.charAt(idx) == s2.charAt(j)){
            canInterleave = findInterleave(s1,s2,s3,i,j+1);
        }

        return dp[i][j] = canInterleave;
    }
}