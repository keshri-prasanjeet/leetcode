class Solution {
    List<String> answer;
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        generateParenthesis(n, new StringBuilder(), n);
        return answer;
    }

    private void generateParenthesis(int open, StringBuilder sb, int close){
        if(open == 0 && close ==0){
            answer.add(sb.toString());
            return;
        }

        if(open > 0){
            sb.append("(");
            generateParenthesis(open-1, sb, close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close > open){
            sb.append(")");
            generateParenthesis(open, sb, close-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}