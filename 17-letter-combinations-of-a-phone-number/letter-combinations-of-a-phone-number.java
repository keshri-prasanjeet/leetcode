class Solution {
    String[] keypadChars = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> answer;
    public List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(!digits.isEmpty())doCombinations(sb, digits, 0);
        return answer;
    }

    private void doCombinations(StringBuilder sb, String digits, int index){
        if(index == digits.length()){
            answer.add(sb.toString());
            return;
        }

        int buttonNum = digits.charAt(index) - '0' -2;
        String buttonChars = keypadChars[buttonNum];

        for(int i=0;i<buttonChars.length();i++){
            sb.append(buttonChars.charAt(i));
            doCombinations(sb, digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}