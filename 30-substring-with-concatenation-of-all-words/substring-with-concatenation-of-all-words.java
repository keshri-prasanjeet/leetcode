class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int sLen = s.length();
        int wordsLen = words.length;
        int wLen = words[0].length();
        int substringLen = wordsLen * wLen;

        if(sLen < substringLen) return new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        for(String w: words){
            freqMap.put(w, freqMap.getOrDefault(w, 0) +1);
        }
        for(int i=0;i<wLen;i++){//start at 0,1,2,... single word length first word, bar, arf, rfo (just doing in master loop is enough since j loop always goes till end)
            int windowStart=i;
            Map<String, Integer> checkMap = new HashMap<>();
            int count = 0;
            for(int j=i;j<=sLen - wLen;j+=wLen){//tries to go till the end everytime
                String sub = s.substring(j, j+wLen);
                if(freqMap.containsKey(sub)){
                    checkMap.put(sub, checkMap.getOrDefault(sub, 0)+1);
                    count++;
                    while(checkMap.get(sub) > freqMap.get(sub)){
                        String leftMostWord = s.substring(windowStart, windowStart+wLen);
                        checkMap.put(leftMostWord, checkMap.get(leftMostWord)-1);
                        count--;
                        windowStart+=wLen;
                    }

                    if(count == wordsLen){
                        ans.add(windowStart);
                        String leftMostWord = s.substring(windowStart, windowStart+wLen);
                        checkMap.put(leftMostWord, checkMap.get(leftMostWord)-1);
                        count--;
                        windowStart+=wLen;
                    }
                }
                else{
                    checkMap.clear();
                    count = 0;
                    windowStart = j+wLen;
                }
            }
        }
        return ans;
    }
}