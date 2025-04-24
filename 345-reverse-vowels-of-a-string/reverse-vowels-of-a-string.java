class Solution {
    public String reverseVowels(String s) {
        int len = s.length();
        boolean vowelArray[] = new boolean[128];
        for(char a: "aeiouAEIOU".toCharArray()){
            vowelArray[a] = true;
        }
        int left = 0;
        int right = len-1;
        char[] sArr = s.toCharArray();
        while(left<right){
            while(left<right && !vowelArray[sArr[left]]){
                left++;
            }
            while(left<right && !vowelArray[sArr[right]]){
                right--;
            }
            if(left<right){
                char temp = sArr[left];
                sArr[left] = sArr[right];
                sArr[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(sArr);
    }
}