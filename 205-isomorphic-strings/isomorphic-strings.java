class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> isometricMap = new HashMap<>();
        Set<Character> usedChars = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(isometricMap.containsKey(s.charAt(i))){
                if(isometricMap.get(s.charAt(i)) != t.charAt(i)) return false;
            }
            else{
                if(usedChars.contains(t.charAt(i))) return false;
                isometricMap.put(s.charAt(i), t.charAt(i));
                usedChars.add(t.charAt(i));
            }
        }
        return true;
    }
}