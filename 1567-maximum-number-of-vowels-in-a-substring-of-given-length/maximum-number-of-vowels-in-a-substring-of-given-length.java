class Solution {
    public int maxVowels(String s, int k) {
        int[] vowelMap = new int[26];
        for(char a: "aeiou".toCharArray()){
            vowelMap[a-'a']++;
        }
        int l = 0;
        int r = 0;
        int vowelFound = 0;
        int maxVowel = Integer.MIN_VALUE;
        while(r< s.length()){
            char chR = s.charAt(r);
            if(vowelMap[chR-'a']!=0) vowelFound++;
            if(r-l+1 > k){
                char chL = s.charAt(l);
                if(vowelMap[chL-'a']!=0) vowelFound--;
                l++;
            }
            maxVowel = Math.max(maxVowel, vowelFound);
            r++;
        }
        return maxVowel;
    }
}