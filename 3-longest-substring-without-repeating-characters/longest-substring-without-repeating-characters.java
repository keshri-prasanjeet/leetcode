class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charMap = new HashSet<>();
        int lenOfSub = 0;
        int longestSub = 0;
        int l = 0;
        int r = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(!charMap.contains(ch)){
                charMap.add(ch);
                lenOfSub++;
                longestSub = Math.max(longestSub, r-l+1);
                r++;
            }
            else{
                while(charMap.contains(ch)){
                    charMap.remove(s.charAt(l++));
                }
            }
        }
        return longestSub;
    }
}