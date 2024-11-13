class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            int left = i;
            int right = i;
            while(left >=0 && right < len && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }

            left = i;
            right =i+1;

            while(left >=0 && right < len && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }

        }
        return count;
    }
}