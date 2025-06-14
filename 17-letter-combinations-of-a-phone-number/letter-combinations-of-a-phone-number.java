class Solution {
    String[] charMap = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> answer;
    public List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(!digits.isEmpty()) doCombination(digits, sb, 0);
        return answer;
    }

    private void doCombination(String digits, StringBuilder combination, int index){
        if(index==digits.length()){
            answer.add(combination.toString());
            return;
        }

        int keyPadNum = digits.charAt(index) - '0' - 2;
        String keyPadLetters = charMap[keyPadNum];

        for(int i=0;i<keyPadLetters.length();i++){
            combination.append(keyPadLetters.charAt(i));
            doCombination(digits, combination, index+1);
            combination.deleteCharAt(combination.length()-1);
        }
    }
}