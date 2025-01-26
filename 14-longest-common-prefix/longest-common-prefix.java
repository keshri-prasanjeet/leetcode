class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len==1) return strs[0];
        String firstString = strs[0];
        String ans = "";
        int count = 0;
        for(int i=0;i<firstString.length();i++){
            for(int j=1;j<len;j++){
                if(i <= strs[j].length()-1){
                    if(firstString.charAt(i) == strs[j].charAt(i)){
                        count++;
                    }
                    else break;
                }
            }
            System.out.println(count);
            if(count == len-1) {
                ans+=firstString.charAt(i);
                count = 0;
            }
            else break;
        }
        return ans;
    }
}