class Solution {
    List<String> allParenthesis;
    public List<String> generateParenthesis(int n) {
        allParenthesis = new ArrayList<>();
        makeParenthesis(n,n,new StringBuilder());
        return allParenthesis;
    }

    private void makeParenthesis(int open, int clos, StringBuilder sb){
        if(open>0){
            sb.append("(");
            makeParenthesis(open-1, clos, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(clos > open && clos > 0){
            sb.append(")");
            makeParenthesis(open, clos-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open == clos && clos == 0){
            allParenthesis.add(sb.toString());
        }
    }
}