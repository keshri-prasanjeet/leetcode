class Solution {
    List<String> answer;
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(n, n, sb);
        return answer;
    }

    private void generate(int o, int c, StringBuilder sb){
        if(o==0 && c==0){
            answer.add(new String(sb.toString()));
            return;
        }
        if(o > 0){
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append("(");
            generate(o-1, c, new StringBuilder(newSb));
        }
        if(o < c && c > 0){
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(")");
            generate(o, c-1, new StringBuilder(newSb));
        }
    }
}