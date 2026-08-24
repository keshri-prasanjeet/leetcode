class Solution {
    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length()-1;
        while(lo < hi){
            lo = advanceLeft(s, lo, hi);
            hi = advanceRight(s,lo, hi);
            if(lo >= hi) return true;
            if(!equalsIgnoreCase(s.charAt(lo), s.charAt(hi))) return false;
            lo++;
            hi--;
        }
        return true;
    }

    private static int advanceLeft(String s, int lo, int hi){
        while(lo < hi && !Character.isLetterOrDigit(s.charAt(lo))) lo++;
        return lo;
    }

    private static int advanceRight(String s, int lo, int hi){
        while(lo < hi && !Character.isLetterOrDigit(s.charAt(hi))) hi--;
        return hi;
    }

    private static boolean equalsIgnoreCase(char a, char b){
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}