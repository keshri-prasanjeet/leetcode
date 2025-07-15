class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] freqMap = new int[26];
        for(char a: s1.toCharArray()){
            freqMap[a-'a']++;
        }

        int left = 0;
        int right = 0;
        int matchFound = 0;
        int s1Len = s1.length();
        while(right < s2.length()){
            
            if(freqMap[s2.charAt(right)-'a'] > 0) matchFound++;
            freqMap[s2.charAt(right)-'a']--;
            if(matchFound == s1Len) return true;
            if(right - left +1 == s1Len){
                if(freqMap[s2.charAt(left)-'a'] >= 0) matchFound--;
                freqMap[s2.charAt(left)-'a']++;
                left++;
            }
            right++;
        }
        return false;
    }
}