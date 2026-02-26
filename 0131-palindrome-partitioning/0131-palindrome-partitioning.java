class Solution {
    List<List<String>> palindromes;
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        palindromes = new ArrayList<>();
        int len = s.length();
        dp = new boolean[len][len];
        //palindrome precompute
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i <= 2) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }
            }
        }
        findPalindromes(s, 0, new ArrayList<>());
        return palindromes;
    }

    private void findPalindromes(String s, int start, List<String> palindrome){
        if(start == s.length()){
            palindromes.add(new ArrayList<>(palindrome));
            return;
        }

        for(int i=start;i<s.length();i++){
            if(dp[start][i] == true){
                String subStr = s.substring(start, i+1);
                palindrome.add(subStr);
                findPalindromes(s, i+1, palindrome);
                palindrome.remove(palindrome.size()-1);
            }
        }
    }
}