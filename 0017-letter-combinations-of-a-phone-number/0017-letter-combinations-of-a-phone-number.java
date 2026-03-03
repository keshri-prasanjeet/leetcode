class Solution {
    List<List<Character>> keyMappings = List.of(
        List.of('a','b','c'),
        List.of('d','e','f'),
        List.of('g','h','i'),
        List.of('j','k','l'),
        List.of('m','n','o'),
        List.of('p','q','r','s'),
        List.of('t','u','v'),
        List.of('w','x','y','z')
    );
    int digLen;
    List<String> answer;
    public List<String> letterCombinations(String digits) {
        digLen = digits.length();
        answer = new ArrayList<>();
        if(digLen == 0) return answer;
        findLetterCombinations(digits.toCharArray(), 0, new StringBuilder());
        return answer;
    }

    private void findLetterCombinations(char[] digits, int index, StringBuilder sb){
        if(index == digits.length){
            answer.add(sb.toString());
            return;
        }

        List<Character> keySpace = keyMappings.get(digits[index]-'0' -2);
        for(int i=0;i<keySpace.size();i++){
            char press = keySpace.get(i);
            sb.append(press);
            findLetterCombinations(digits, index+1, sb);
            sb.setLength(sb.length()-1);
        }
    }
}