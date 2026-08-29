class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1Len > s2Len) return false;
        // if(s1Len == s2Len && !s1.equals(s2)) return false;

        int[] charMap = new int[26];

        for(char a: s1.toCharArray()){
            charMap[a - 'a']++;
        }
        int req = s1Len;
        int left = 0;
        for(int right = 0;right<s2Len;right++){
            char rightChar = s2.charAt(right);
            if(charMap[rightChar - 'a'] > 0) req--;
            charMap[rightChar - 'a']--;
            if(right - left + 1 == s1Len){
                if(req == 0) return true;
                char leftChar = s2.charAt(left);
                if(charMap[leftChar-'a']>=0) req++;
                charMap[leftChar - 'a']++;
                left++;
            }
        }
        return false;
    }
}