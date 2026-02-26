class Solution {
    List<List<String>> palindromes;
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        palindromes = new ArrayList<>();
        dp = new boolean[s.length()][s.length()];
        findPalindromes(s, 0, new ArrayList<>());
        return palindromes;
    }

    private void findPalindromes(String s, int start, List<String> palindrome){
        if(start == s.length()){
            palindromes.add(new ArrayList<>(palindrome));
            return;
        }

        for(int i=start;i<s.length();i++){
            if(isPalindrome(s, start, i)){
                dp[start][i] = true;
                String subStr = s.substring(start, i+1);
                palindrome.add(subStr);
                findPalindromes(s, i+1, palindrome);
                palindrome.remove(palindrome.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        int left = start;
        int right=end;
        if(dp[left][right] == true) return true;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}