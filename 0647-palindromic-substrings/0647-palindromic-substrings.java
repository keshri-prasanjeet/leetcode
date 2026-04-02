class Solution {

    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] palindromeCompute = new boolean[len][len];
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i<=2) palindromeCompute[i][j] = true;
                    else palindromeCompute[i][j] = palindromeCompute[i+1][j-1];
                }
            }
        }
        int count = 0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(palindromeCompute[i][j] == true){
                    count++;
                }
            }
        }
        return count;
    }
}