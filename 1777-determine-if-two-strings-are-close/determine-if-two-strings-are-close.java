class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> w1 = new HashMap<>();
        Map<Character, Integer> w2 = new HashMap<>();
        int len = word1.length();
        if(len != word2.length()) return false;
        for(int i=0;i<len;i++){
            char a = word1.charAt(i);
            char b = word2.charAt(i);
            w1.put(a, w1.getOrDefault(a, 0)+1);
            w2.put(b, w2.getOrDefault(b, 0)+1);
        }
        for(Character c: w1.keySet()){
            if(!w2.containsKey(c)) return false;
        }
        int[] letters = new int[100000];
        for(Integer i: w1.values()){
            letters[i]++;
        }

        for(Integer j: w2.values()){
            if(letters[j] == 0) return false;
            letters[j]--;
        }
        return true;
    }
}