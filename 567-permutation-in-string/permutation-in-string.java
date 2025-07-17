class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s2Len < s1Len) return false;
        int[] s1FreqMap = new int[26];

        for(char s: s1.toCharArray()){
            s1FreqMap[s-'a']++;
        }//populated the frequency

        int l = 0;
        int r = 0;
        int matchingChars = 0;
        while(r < s2Len){
            char chR = s2.charAt(r);
            if(s1FreqMap[chR - 'a']>0) matchingChars++;
            s1FreqMap[chR - 'a']--;
            if(matchingChars == s1Len) return true;
            if(r-l+1 == s1Len){
                //we have exceeded the window size
                char chL = s2.charAt(l);
                if(s1FreqMap[chL-'a'] >=0) matchingChars--;
                s1FreqMap[chL-'a']++;
                l++;
            }
            r++;
        }
        return false;
    }
}