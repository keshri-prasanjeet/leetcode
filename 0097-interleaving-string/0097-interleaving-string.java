class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        //two indices, one for s1 and one for s2
        //if indices reach out of bound for both i have made the word, return true
        // there are two choices, follow s1 , follow s2, if neither matches then return false
        // do or operations such that either subtree returns true then accept it
        if(s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return findInterleave(s1, s2, s3, 0, 0);
    }

    private boolean findInterleave(String s1, String s2, String s3, int i, int j){
        if(dp[i][j]!=null) return dp[i][j];
        
        int idx = i+j;

        if(i == s1.length() && j == s2.length()) return dp[i][j] = true;

        boolean canInterleave = false;

        if(i<s1.length() && s1.charAt(i) == s3.charAt(idx)){
            canInterleave = findInterleave(s1,s2,s3,i+1,j);
        }

        if(!canInterleave && j<s2.length() && s2.charAt(j) == s3.charAt(idx)){
            canInterleave = findInterleave(s1,s2,s3,i,j+1);
        }
        return dp[i][j] = canInterleave;
    }
}