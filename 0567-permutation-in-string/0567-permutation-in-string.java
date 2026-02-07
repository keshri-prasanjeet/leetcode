class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s2Len < s1Len) return false;
        int[] charMap = new int[26];
        for(char a: s1.toCharArray()){
            charMap[a-'a']++;
        }
        int left = 0;
        int right = 0;
        int required = s1Len;
        while(right < s2Len){
            char rightChar = s2.charAt(right);
            if(charMap[rightChar - 'a']>0){
                required--;
            }
            charMap[rightChar - 'a']--;
            if(right - left + 1 == s1Len){
                if(required == 0) return true;
                char leftChar = s2.charAt(left);
                if(charMap[leftChar - 'a'] >=0){
                    required++;
                }
                charMap[leftChar - 'a']++;
                left++;
            }
            right++;
        }
        return false;
    }
}