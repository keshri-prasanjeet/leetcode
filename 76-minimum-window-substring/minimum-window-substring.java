class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] tMap = new int[128];
        for (char a : t.toCharArray()) {
            tMap[a]++;
        }

        int totalMatches = 0;
        for (int i : tMap)
            if (i > 0)
                totalMatches++;

        int left = 0;
        int right = 0;
        int matchFound = 0;
        int[] windowMap = new int[128];
        int minLen = Integer.MAX_VALUE;
        int startLen = left;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowMap[rightChar]++;

            if (tMap[rightChar] > 0 &&
                    tMap[rightChar] == windowMap[rightChar])
                matchFound++;
            while (matchFound == totalMatches) {
                //calculate the min
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    startLen = left;
                }

                //remove the left and see what happens
                char leftChar=s.charAt(left);
                windowMap[s.charAt(left)]--;
                if(tMap[s.charAt(left)] > 0 && tMap[s.charAt(left)] > windowMap[s.charAt(left)]){
                    matchFound--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startLen, startLen + minLen);

    }
}