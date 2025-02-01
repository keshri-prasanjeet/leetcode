class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int increment = (numRows -1) * 2;
        for(int i=0;i<numRows;i++){
            for(int j=i;j<s.length();j+=increment){
                sb.append(s.charAt(j));
                if(i>0 && i<numRows-1){
                    int inMiddle = j + increment - (2 * i);
                    if(inMiddle < s.length()){
                        sb.append(s.charAt(inMiddle));
                    }
                }
            }
        }
        return sb.toString();
    }
}