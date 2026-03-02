class Solution {
List<List<String>> charMap = new ArrayList<>
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
    int strLen;
    public List<String> letterCombinations(String digits) {

        strLen = digits.length();
        answer = new ArrayList<>();
        if(strLen == 0) return answer;

        findCombinations(digits, new StringBuilder(), 0);
        return answer;
    }

    private void findCombinations(String digits, StringBuilder sb, int index){
        if(sb.length() == strLen){
            answer.add(sb.toString());
            return;
        }

        int num = digits.charAt(index) - '0' -2;
        for(int i=0;i<charMap.get(num).size();i++){
            sb.append(charMap.get(num).get(i));
            findCombinations(digits, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}