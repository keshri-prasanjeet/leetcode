class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int len = strs.length;
        if(len==1) return prefix;
        for(int i=0;i<len;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
}