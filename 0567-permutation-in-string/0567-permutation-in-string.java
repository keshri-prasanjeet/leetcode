class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s2Len = s2.length();
        int s1Len = s1.length();
        if(s1Len > s2Len) return false;
        int left = 0;
        int right = 0;
        int req = s1Len;

        int[] charMap = new int[26];
        for(char a: s1.toCharArray()){
            charMap[a-'a']++;
        }

        while(right < s2Len){
            char rightChar = s2.charAt(right);
            if(charMap[rightChar - 'a']>0) req--;
            charMap[rightChar - 'a']--;

            if(right - left + 1 == s1Len){
                //window has been created
                if(req == 0) return true;
                char leftChar = s2.charAt(left);
                if(charMap[leftChar - 'a']>=0) req++;
                charMap[leftChar - 'a']++;
                left++;
            }
            right++;
        }
        return false;
    }
}