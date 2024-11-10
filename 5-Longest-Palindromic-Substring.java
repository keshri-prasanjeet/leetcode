class Solution {
    public String longestPalindrome(String s) {
        int resLen = 0;
        StringBuilder sb = new StringBuilder();
        String res = \\;
        for(int i=0;i<s.length();i++){
            int left = i;
            int right = i;
            while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)){

                if(right-left+1 > resLen){
                    res = s.substring(left, right+1);
                    resLen = right-left+1;
                }
                left--;
                right++;
                
            }


            left = i;
            right = i+1;
            while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)){

                if(right-left+1 > resLen){
                    res = s.substring(left, right+1);
                    resLen = right-left+1;
                }
                left--;
                right++;
            }  
              
        }

        return res;
    }
}