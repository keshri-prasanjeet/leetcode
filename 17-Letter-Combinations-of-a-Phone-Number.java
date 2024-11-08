class Solution {
    String[] phoneLetters = new String[]{\abc\,\def\,\ghi\,\jkl\,\mno\,\pqrs\,\tuv\,\wxyz\};
    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        if(!digits.isEmpty()) backTrack(ans, 0, cur, digits);
        return ans;
    }

    private void backTrack(List<String> ans, int index, StringBuilder cur, String digits){
        if(digits.length()==cur.length()){
            ans.add(cur.toString());
            return;
        }

        int num = digits.charAt(index) - '0' - 2;
        String letters = phoneLetters[num];
        for(int i=0;i<letters.length();i++){
            cur.append(letters.charAt(i));
            backTrack(ans, index+1, cur, digits);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}