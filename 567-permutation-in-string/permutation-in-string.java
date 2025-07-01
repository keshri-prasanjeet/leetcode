class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] characterMap = new int[26];
        for(char a:s1.toCharArray()){
            characterMap[a-'a']++;
        }
        int left = 0;
        int right = 0;
        int matchesFound = 0;
        while(right < s2.length()){
            char rightCh = s2.charAt(right);
            if(characterMap[rightCh-'a'] > 0) {
                matchesFound++;
            }
            characterMap[s2.charAt(right)-'a']--;
            if(matchesFound == s1.length()) return true;
            if(right-left+1 == s1.length()){
                if(characterMap[s2.charAt(left)-'a'] >= 0) matchesFound--;
                characterMap[s2.charAt(left)-'a']++;
                left++;
            }
            right++;
        }
        return false;
    }
}