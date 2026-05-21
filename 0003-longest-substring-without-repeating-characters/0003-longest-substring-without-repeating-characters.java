class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int sLen = s.length();
        int start = 0;
        int max = 0;
        for(int i = 0;i<sLen;i++){
            char a = s.charAt(i);
            if(!charSet.contains(a)){
                charSet.add(a);
            }
            else{
                while(charSet.contains(a)){
                    charSet.remove(s.charAt(start));
                    start++;
                }
                charSet.add(a);
            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}