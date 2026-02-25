class Solution {
    List<String> allParentheses;
    public List<String> generateParenthesis(int n) {
        allParentheses = new ArrayList<>();
        generate(n, n, new StringBuilder());
        return allParentheses;
    }

    private void generate(int open, int close, StringBuilder sb){
        if(open == 0 && close == 0) {
            allParentheses.add(sb.toString());
            return;
        }
        if(open > 0){
            sb.append("(");
            generate(open-1,close,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close > open){
            sb.append(")");
            generate(open, close-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}