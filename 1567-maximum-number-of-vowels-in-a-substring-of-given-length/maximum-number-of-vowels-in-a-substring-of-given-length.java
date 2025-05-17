class Solution {
    public int maxVowels(String s, int k) {
        boolean[] vowels = new boolean[128];
        for(char a: "aeiouAEIOU".toCharArray()){
            vowels[a] = true;
        }

        int vowelCount = 0;
        for(int i=0;i<k;i++){
            if(vowels[s.charAt(i)]==true){
                vowelCount++;
            }
        }
        int start = 0;
        int end = k;
        int maxVowels = vowelCount;
        while(end<s.length()){
            if(vowels[s.charAt(end++)]==true){
                vowelCount++;
            }
            if(vowels[s.charAt(start++)]==true){
                vowelCount--;
            }
            maxVowels = Math.max(maxVowels, vowelCount);
        }
        return maxVowels;
    }
}