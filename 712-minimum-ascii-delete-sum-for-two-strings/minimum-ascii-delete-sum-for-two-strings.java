class Solution {
    Integer[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        dp = new Integer[l1][l2];
        return calcDel(s1, s2, l1-1, l2-1);
    }

    private int calcDel(String s, String t, int i, int j){
        if(i < 0){
            int sum = 0;
            while(j>=0){
                sum+=t.charAt(j);
                j--;
            }
            return sum;
        }
        if(j<0){
            int sum = 0;
            while(i>=0){
                sum+=s.charAt(i);
                i--;
            }
            return sum;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = calcDel(s, t, i-1, j-1);
        }
        else{
            int delete1 = calcDel(s, t, i-1, j);
            int delete2 = calcDel(s, t, i, j-1);

            return dp[i][j] = Math.min( 
                (delete1 + (int)s.charAt(i)), 
                (delete2 + (int)t.charAt(j))
                );
        }
    }
}