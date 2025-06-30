class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> substringSet = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(left <= right && right < s.length()){
            char ch = s.charAt(right);
            if(!substringSet.contains(ch)){
                substringSet.add(ch);
                maxLen = Math.max(maxLen, right-left+1);
                right++;
            }
            else{
                while(substringSet.contains(ch) && left <= right){
                    substringSet.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return maxLen;
    }
}