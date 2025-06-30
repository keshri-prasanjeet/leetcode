class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqCount = new HashMap<>();
        int l = 0;
        int maxWindow = 0;
        int maxAppearedChar = 0;
        for(int r = 0;r<s.length();r++){
            char chR = s.charAt(r);
            freqCount.put(chR, freqCount.getOrDefault(chR,0) +1);
            maxAppearedChar = Math.max(maxAppearedChar, freqCount.get(chR));
            while((r-l+1)-maxAppearedChar > k){
                freqCount.put(s.charAt(l), freqCount.get(s.charAt(l))-1);
                l++;
            }
            maxWindow = Math.max(maxWindow, r-l+1);
        }
        return maxWindow;
    }
}