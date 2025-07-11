class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0;
        int right = len-1;
        while(left <=right){
            while(left<len && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while(right >=0 && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if(left== len || right == 0) return true;
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }
}