class Solution {
    String[] letterMap = new String[]{\abc\, \def\, \ghi\, \jkl\, \mno\, \pqrs\, \tuv\, \wxyz\};
    public List<String> letterCombinations(String digits) {
        
        List<String> letterCombinations = new ArrayList<>();
        StringBuilder combination = new StringBuilder();
        if(!digits.isEmpty()) dfs(digits, 0, letterCombinations, combination);
        return letterCombinations;
    }

    private void dfs(String digits, int index, List<String> letterCombinations, StringBuilder combination){
        if(index==digits.length()){
            letterCombinations.add(combination.toString());
            return;
        }

        String letters = letterMap[digits.charAt(index) - '0' -2];
        for(int i=0;i<letters.length();i++){
            combination.append(letters.charAt(i));
            dfs(digits, index+1, letterCombinations, combination);
            combination.deleteCharAt(combination.length()-1);
        }
        return;
    }
}