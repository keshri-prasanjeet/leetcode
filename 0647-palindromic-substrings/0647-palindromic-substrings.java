class Solution {
    public int countSubstrings(String s) {
        //what if i precompute all the palindromes
        //and then i do nested loop
        //or better an even odd expansion
        int len = s.length();
        int even = 0;
        int odd = 0;
        // for(int i=0;i<len;i++){
        //     odd += expandPalindrome(s, i, i);
        //     even+= expandPalindrome(s, i, i+1);
        // }
        // return odd+even;

        return IntStream.range(0, s.length())
            .map(i -> expandPalindrome(s, i, i) + expandPalindrome(s, i, i+1))
            .sum();
    }

    private int expandPalindrome(String s, int left, int right){
        int count = 0;
        while(left >=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}