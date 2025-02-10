class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] splitted= s.split(" ");
        // for(int i=0;i<splitted.length;i++){
        //     System.out.println(splitted[i]);
        // }
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<String, Integer> wordMap = new HashMap<>();
        int patternNum = 1;
        int pIntermediate = 0;
        for(char p: pattern.toCharArray()){
            if(!patternMap.containsKey(p)){
                pIntermediate = pIntermediate * 10 + patternNum;
                patternMap.put(p, patternNum++);
            }
            else{
                pIntermediate = pIntermediate * 10 + patternMap.get(p);
            }
        }
        patternNum = 1;
        int wIntermediate = 0;
        for(String word: splitted){
            if(!wordMap.containsKey(word)){
                wIntermediate = wIntermediate * 10 + patternNum;
                wordMap.put(word, patternNum++);
            }
            else{
                wIntermediate = wIntermediate * 10 + wordMap.get(word);
            }
        }
        System.out.println(pIntermediate + " " + wIntermediate);
        if(pIntermediate == wIntermediate) return true;
        return false;
    }
}