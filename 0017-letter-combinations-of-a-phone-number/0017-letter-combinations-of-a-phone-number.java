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

    List<String> answer;
    public List<String> letterCombinations(String digits) {
        //just a loop would suffice
        //take the first character from the list of the digit
        //recurse until used all
        //backtrack remove last used and use the next loop index
        char[] digitArr = digits.toCharArray();
        answer = new ArrayList<>();
        findAllCombinations(digitArr, 0, new StringBuilder());
        return answer;
    }

    private void findAllCombinations(char[] digitArr, int index, StringBuilder sb){
        if(index == digitArr.length){
            answer.add(sb.toString());
            return;
        }
        char keyPressed = digitArr[index];
        int intKey = (keyPressed - '0') - 2;
        List<Character> charList = keyMappings.get(intKey);

        for(int i=0;i<charList.size();i++){
            sb.append(charList.get(i));
            findAllCombinations(digitArr, index+1, sb);
            sb.setLength(sb.length()-1);
        }
    }
}