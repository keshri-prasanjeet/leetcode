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

        for(int l = Math.min(len1, len2); l>0; l--){
            if(findGCD(l) == true){
                return str1.substring(0, l);
            }
        }
        return "";
    }

    private boolean findGCD(int len){
        if(len1 % len != 0 || len2 % len != 0) return false;
        String sub1 = s1.substring(0,len);
        // System.out.println(sub1);
        int rep1 = len1 / len;
        int rep2 = len2 / len;
        return s1.equals(sub1.repeat(rep1)) && s2.equals(sub1.repeat(rep2));
    }
}