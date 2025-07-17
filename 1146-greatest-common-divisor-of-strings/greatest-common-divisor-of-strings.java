class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        for(int i=Math.min(len1,len2);i>0;i--){
            if(findGCD(i,len1,len2,str1,str2) == true){
                return str1.substring(0,i);
            }
        }
        return "";
    }

    private boolean findGCD(int len,int len1, int len2, String s, String t){
        if(len1 % len != 0 || len2 % len != 0) return false;
        int repet1 = len1/len;
        int repet2 = len2/len;
        String sub = s.substring(0,len);
        return (s.equals(sub.repeat(repet1))) && (t.equals(sub.repeat(repet2)));
    }
}