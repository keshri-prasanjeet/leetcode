class Solution {
    
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        return isSub(s, t, len1-1, len2-1);
    }

    private boolean isSub(String s, String t, int i, int j){
        if(i<0) return true;
        if(j<0) return false;
        
        if(s.charAt(i) == t.charAt(j)){
            return isSub(s, t, i-1, j-1);
        }
        else{
            return isSub(s, t, i, j-1);
        }
    }
}