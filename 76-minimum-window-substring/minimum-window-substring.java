class Solution {
    public String minWindow(String s, String t) {
        int[] tMap = new int[128];
        for(char a: t.toCharArray()){
            tMap[a]++;
        }

        int totalRequired = 0;
        for(int i:tMap)
            if(i>0) 
                totalRequired++;
        
        int right = 0;
        int left = 0;
        int[] sMap = new int[128];
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int matchFound = 0;
        while(right< s.length()){
            char rightChar = s.charAt(right);
            sMap[rightChar]++;
            if(tMap[rightChar] > 0 && sMap[rightChar] == tMap[rightChar]) matchFound++;

            while(matchFound == totalRequired){

                if(minLen > (right-left+1)){
                    minLen = right-left+1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                sMap[leftChar]--;
                if(tMap[leftChar] > 0 && tMap[leftChar] > sMap[leftChar]){
                    matchFound--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
    }
}