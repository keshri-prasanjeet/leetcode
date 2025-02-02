class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(lenS==0) return true;
        if(lenS > lenT) return false;
        int i=0;
        int j=0;
        while(i<lenS){
            while(j<lenT && t.charAt(j)!=s.charAt(i)){
                j++;
            }
            if(j<lenT){
                i++;
                j++;
                if(i==lenS)return true;
            }
            else break;
        }
        return false;
    }
}