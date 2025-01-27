class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);

        int hayLen = haystack.length();
        int neeLen = needle.length();
        if(neeLen > hayLen) return -1;
        if(needle.equals(haystack.substring(0, neeLen))) return 0;
        for(int i=0;i<=hayLen-neeLen;i++){
            if(needle.equals(haystack.substring(i, i+neeLen))) return i;
        }
        return -1;
    }
}