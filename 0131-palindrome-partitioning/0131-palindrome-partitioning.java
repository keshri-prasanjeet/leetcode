class Solution {
    List<List<String>> palindromes;
    public List<List<String>> partition(String s) {
        palindromes = new ArrayList<>();
        findPalindromes(s, 0, new ArrayList<>());
        return palindromes;
    }

    private void findPalindromes(String s, int start, List<String> palindrome){
        if(start == s.length()){
            palindromes.add(new ArrayList<>(palindrome));
            return;
        }

        for(int i=start;i<s.length();i++){
            String subStr = s.substring(start, i+1);
            if(isPalindrome(subStr)){
                palindrome.add(subStr);
                findPalindromes(s, i+1, palindrome);
                palindrome.remove(palindrome.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right=s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}