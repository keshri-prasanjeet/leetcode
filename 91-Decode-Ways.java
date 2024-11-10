class Solution {
    public int numDecodings(String s) {
        Map<Integer,Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return countDecoding(s, 0, dp);
    }

    private int countDecoding(String s, int index, Map<Integer, Integer> dp){
        if(dp.containsKey(index)) return dp.get(index);

        if(index >= s.length()) return 0;

        if(s.charAt(index)=='0') return 0;

        int res = 0;

        res+=countDecoding(s,index+1,dp);

        if(index +1 < s.length() && 
            (
                (s.charAt(index) == '1') || 
                    (s.charAt(index) == '2' && 
                        (
                            s.charAt(index+1) == '0' || 
                            s.charAt(index+1) == '1' || 
                            s.charAt(index+1) == '2' ||
                            s.charAt(index+1) == '3' ||
                            s.charAt(index+1) == '4' ||
                            s.charAt(index+1) == '5' ||
                            s.charAt(index+1) == '6'
                        )
                    )
                )
            ){
                res+=countDecoding(s, index+2,dp);
            }
        
        dp.put(index, res);
        return res;
    }
}