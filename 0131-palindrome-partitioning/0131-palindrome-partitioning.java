class Solution {
    List<List<String>> answer;
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        answer = new ArrayList<>();
        //precompute the palindromes
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }
            }
        }

        findPalindromePartitions(s, dp, 0, new ArrayList<>());
        return answer;
    }

    private void findPalindromePartitions(String s, boolean[][] dp, int idx, List<String> palindromeSubsets){
        if(idx == s.length()){
            answer.add(new ArrayList<>(palindromeSubsets));
            return;
        }

        for(int i=idx;i<s.length();i++){
            if(dp[idx][i]){
                String substring = s.substring(idx, i+1);
                palindromeSubsets.add(substring);
                findPalindromePartitions(s, dp, i+1, palindromeSubsets);
                palindromeSubsets.remove(palindromeSubsets.size()-1);
            }
        }
    }
}