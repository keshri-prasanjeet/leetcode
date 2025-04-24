class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = Set.of('a','e','i','o','u','A','E','I','O','U');
        char[] sArr = s.toCharArray();
        int len = s.length();
        int left = 0;
        int right = len-1;
        boolean lVow = false;
        boolean rVow = false;
        while(left <= right && left < len && right > -1){
            if(set.contains(sArr[left])){
                lVow = true;
            }
            else{
                left++;
            }
            if(set.contains(sArr[right])){
                rVow = true;
            }
            else{
                right--;
            }
            if(lVow == true && rVow == true){
                // System.out.println(left + " " + right);
                char temp = sArr[left];
                sArr[left] = sArr[right];
                sArr[right] = temp;
                // System.out.println(sArr[left] + " " + sArr[right]);
                left++;
                right--;
                lVow = false;
                rVow = false;
            }
        }
        return new String(sArr);
    }
}