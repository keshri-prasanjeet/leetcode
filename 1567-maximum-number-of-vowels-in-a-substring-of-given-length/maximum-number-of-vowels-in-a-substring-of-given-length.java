class Solution {
    public int maxVowels(String s, int k) {
        int vowelCount = 0;
        boolean[] arr = new boolean[128];
        for(char c: "aeiouAEIOU".toCharArray()){
            arr[c] = true;
        }
        for(int i=0;i<k;i++){
            if(arr[s.charAt(i)]==true){
                vowelCount++;
            }
        }
        int maxVowel = vowelCount;
        for(int i=k;i<s.length();i++){
            if(arr[s.charAt(i)] == true){
                vowelCount++;
            }
            if(arr[s.charAt(i-k)] == true){
                vowelCount--;
            }
            maxVowel = Math.max(maxVowel, vowelCount);
        }
        return maxVowel;
    }
}