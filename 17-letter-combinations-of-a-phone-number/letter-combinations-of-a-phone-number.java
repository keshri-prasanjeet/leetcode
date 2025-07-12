class Solution {
    List<List<String>> mapping = new ArrayList<>
    (
        List.of(
            List.of("a","b","c"), 
            List.of("d","e","f"),
            List.of("g","h","i"),
            List.of("j","k","l"),
            List.of("m","n","o"),
            List.of("p","q","r","s"),
            List.of("t","u","v"),
            List.of("w","x","y","z")
        )
    );
    List<String> answer;
    public List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();
        if(digits.length()==0) return answer;
        makeCombination(digits, new StringBuilder(), 0);
        return answer;
    }

    private void makeCombination(String digits, StringBuilder sb, int index){
        if(sb.length() == digits.length()){
            answer.add(sb.toString());
            return;
        }

        int num = digits.charAt(index) - '0' - 2;
        List<String> numList = mapping.get(num);
        for(int i=0;i<numList.size();i++){
            sb.append(numList.get(i));
            makeCombination(digits, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}