class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[128];
        int left = 0;
        int longestSub = 0;
        int maxFreq = 0;
        for(int right = 0;right<s.length();right++){
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            if(freq[idx]>maxFreq) maxFreq = freq[idx];
            while((right - left +1) - maxFreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            longestSub = Math.max(longestSub, right - left +1);
        }
        return longestSub;
    }
}