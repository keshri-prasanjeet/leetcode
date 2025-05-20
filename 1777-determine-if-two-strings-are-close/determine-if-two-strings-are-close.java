class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] map1 = new int[128];
        int[] map2 = new int[128];
        int len = word1.length();
        if(len != word2.length()) return false;

        for(int i=0;i<len;i++){
            map1[word1.charAt(i)]++;
            map2[word2.charAt(i)]++;
        }

        for(int i=0;i<128;i++){
            if((map1[i] ==0 && map2[i]!=0) || (map1[i] !=0 && map2[i]==0)) return false;
        }
        Arrays.sort(map1);
        Arrays.sort(map2);
        return Arrays.equals(map1, map2);
    }
}