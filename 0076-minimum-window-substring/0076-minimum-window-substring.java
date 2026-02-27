class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(tLen > sLen) return "";
        int[] charMap = new int[128];
        for(char a:t.toCharArray()){
            charMap[a]++;
        }

        int left = 0;
        int right = 0;
        int required = tLen;
        int minSSLen = sLen+1;
        int leftIdx = 0;
        int rightIdx = 0;
        while(right < sLen){
            char rightChar = s.charAt(right);
            if(charMap[rightChar]>0){
                required--;
            }
            charMap[rightChar]--;
            while(required == 0){
                char leftChar = s.charAt(left);
                if(minSSLen > (right-left+1)){
                    leftIdx = left;
                    rightIdx= right;
                    minSSLen = right-left+1;
                }
                if(charMap[leftChar]==0){
                    required++;
                }
                charMap[leftChar]++;
                left++;
            }
            right++;
        }
        return minSSLen == (sLen + 1) ? "" : s.substring(leftIdx,rightIdx+1);
    }


}