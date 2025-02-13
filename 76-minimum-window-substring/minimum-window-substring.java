class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c:t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }
        int left=0;
        int right=0;
        int minLen = Integer.MAX_VALUE;
        int windowStart = left;
        int required = tMap.size();
        int found = 0;
        Map<Character, Integer> windowMap = new HashMap<>();
        while(right < s.length()){
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0)+1);
            if(tMap.containsKey(rightChar) && tMap.get(rightChar).equals(windowMap.get(rightChar))){
                found++;
            }
            while(found==required){
                if(minLen > right-left+1){
                    minLen = right-left+1;
                    windowStart = left;
                }
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar)-1);
                if(tMap.containsKey(leftChar) && tMap.get(leftChar) > windowMap.get(leftChar)){
                    found--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(windowStart, windowStart+minLen);
    }
}