class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] precompute = new boolean[len][len];
        preComputePalindrome(s,precompute);
        int longest = -1;
        int startP = -1;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(precompute[i][j] && (j-i+1) > longest){
                    longest = j-i+1;
                    startP = i;
                }
            }
        }
        return s.substring(startP, startP+longest);
    }

    private void preComputePalindrome(String s, boolean[][] p){

        for(int i=s.length();i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i<=2) p[i][j] = true;
                    else p[i][j] = p[i+1][j-1];
                }
            }
        }
    }
}