class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen == tLen) return s.equals(t);
        int i=0;
        int j=0;
        while(i<sLen){
            while(j < tLen && s.charAt(i)!=t.charAt(j)){
                j++;
            }
            if(j<tLen) {
                i++; 
                j++;
            }
            else return false;
        }
        
        return true;
    }
}