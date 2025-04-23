class Solution {
    int len1;
    int len2;
    String s1;
    String s2;
    public String gcdOfStrings(String str1, String str2) {
        len1 = str1.length();
        len2 = str2.length();
        s1 = str1;
        s2 = str2;
        for(int i=Math.min(len1,len2); i>0;i--){
            if(findGCD(i)==true){
                return str1.substring(0,i);
            }
        }
        return "";
    }

    private boolean findGCD(int len){
        if(len1 % len != 0 || len2 % len != 0) return false;
        int rep1 = len1 / len;
        int rep2 = len2 / len;
        String sub = s1.substring(0, len);
        return (s1.equals(sub.repeat(rep1)) && s2.equals(sub.repeat(rep2))); 
    }
}