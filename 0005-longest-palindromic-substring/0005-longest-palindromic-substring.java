class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int longest = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<len;i++){
            int even = expandForPal(i, i, s);
            int odd  = expandForPal(i,i+1,s);

            int curMax = Math.max(even, odd);

            if(curMax > longest){
                longest = curMax;
                start = i-(curMax-1)/2;
                end = i+(curMax/2);
            }
        }
        return s.substring(start, end+1);
    }

    private int expandForPal(int start, int end, String s){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
}