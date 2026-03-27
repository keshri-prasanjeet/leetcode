class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        // we will expand for odd length and even lengths separately
        // after exapnding to the maximum for each point
        // we will check if E OR O gave us the larger length
        // whichever has larger len select that and then divide / 2
        // start would be i - half and end would be i + half

        int start = 0;
        int end = 0;
        for(int i=0;i<len;i++){
            int len1 = expandPalindrome(i, i, s);
            int len2 = expandPalindrome(i, i+1, s);
            // System.out.println("len1 is " + len1 + " len2 is " + len2);
            int maxLen = Math.max(len1, len2);

            if(maxLen > end-start){
                start = i - (maxLen-1)/2;
                end = i + (maxLen/2);
            }
            // System.out.println("start is " + start + " end is " + end);
        }

        return s.substring(start, end+1);
    }

    private int expandPalindrome(int start, int end, String s){
        // System.out.println("started expand at " + start + " " + end);
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            // System.out.println(" start and end matched " + start + " " + end);
            start--;
            end++;
        }
        return end-start-1;
    }
}