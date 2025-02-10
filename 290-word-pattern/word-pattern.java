// class Solution {
//     public boolean wordPattern(String pattern, String s) {
//         String[] splitted= s.split(" ");
//         if(splitted.length != pattern.length()) return false;
//         Map<Character, Integer> patternMap = new HashMap<>();
//         Map<String, Integer> wordMap = new HashMap<>();
//         int patternNum = 1;
//         int pIntermediate = 0;
//         for(char p: pattern.toCharArray()){
//             if(!patternMap.containsKey(p)){
//                 pIntermediate = pIntermediate * 10 + patternNum;
//                 patternMap.put(p, patternNum++);
//             }
//             else{
//                 pIntermediate = pIntermediate * 10 + patternMap.get(p);
//             }
//         }
//         patternNum = 1;
//         int wIntermediate = 0;
//         for(String word: splitted){
//             if(!wordMap.containsKey(word)){
//                 wIntermediate = wIntermediate * 10 + patternNum;
//                 wordMap.put(word, patternNum++);
//             }
//             else{
//                 wIntermediate = wIntermediate * 10 + wordMap.get(word);
//             }
//         }
//         System.out.println(pIntermediate + " " + wIntermediate);
//         if(pIntermediate == wIntermediate) return true;
//         return false;
//     }
// }

class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        if(s==null || s.length()==0 || pattern == null || pattern.length() == 0){
            return false;
        }
        String[] parts = s.split("\\s+");
        if(parts.length != pattern.length()){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                String val = map.get(ch);
                if(!val.equals(parts[i])){
                    return false;
                }
            }else if(!map.containsKey(ch)){
                if(!map.containsValue(parts[i])){
                    map.put(ch, parts[i]);
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
