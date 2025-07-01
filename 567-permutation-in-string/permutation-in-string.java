class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freqMap = new int[26];
        for(char a: s1.toCharArray()){
            freqMap[a-'a']++;
        }

        int left = 0;
        int right= 0;
        int matchLen = 0;
        while(right < s2.length()){
            if(freqMap[s2.charAt(right)-'a'] > 0) matchLen++;
            freqMap[s2.charAt(right)-'a']--;

            if(matchLen == s1.length()) return true;

            if(right-left+1 == s1.length()){
                //window too big reduce size
                if(freqMap[s2.charAt(left)-'a'] >= 0) matchLen--;
                freqMap[s2.charAt(left)-'a']++;
                left++;
            }
            right++;
        }
        return false;
    }
}