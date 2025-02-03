class Solution {
    public int lengthOfLongestSubstring(String s) {
        // abcabcbb
        // if doesn't exist already in set keep on adding
        // if duplicate encountered, keep on removing until we are free of the duplicate
        Set<Character> uniqueChars = new HashSet<>();
        int start = 0;
        int ans = 0;
        int count = 0;
        for(int i=start;i<s.length();i++){
            if(!uniqueChars.contains(s.charAt(i))){
                uniqueChars.add(s.charAt(i));
            }
            else{
                while(uniqueChars.contains(s.charAt(i)) && start < i){
                    uniqueChars.remove(s.charAt(start++));
                    count--;
                }
                uniqueChars.add(s.charAt(i));
            }
            ans = Math.max(ans, ++count);

        }
        return ans;
    }
}