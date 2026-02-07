class Solution {
    public int countGoodSubstrings(String s) {
        // good substring dont have repeating characters in them
        // substring must be of size 3

        int sLen = s.length();
        if(sLen < 3) return 0;
        int left = 0;
        int right = 0;
        int[] charMap = new int[26];
        int duplicate = 0;
        int answer = 0;
        while(right < sLen){
            char rightChar = s.charAt(right);
            charMap[rightChar - 'a']++;
            // System.out.println("right char is " + rightChar + " and the count of right is " + charMap[rightChar - 'a']);
            if(charMap[rightChar - 'a'] > 1){
                duplicate++;
            }
            if(right - left + 1 == 3){
                // System.out.println("duplicate is " + duplicate);
                // System.out.println("left is " + left + " right is " + right);
                char leftChar = s.charAt(left);
                if(duplicate == 0){
                    answer++;
                }
                else{
                    if(charMap[leftChar - 'a']>1) duplicate--;
                }
                charMap[leftChar - 'a']--;
                left++;
            }
            right++;
        }
        return answer;
    }
}