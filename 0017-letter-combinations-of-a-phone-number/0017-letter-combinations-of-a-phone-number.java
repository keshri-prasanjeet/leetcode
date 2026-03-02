class Solution {
    List<List<Character>> charMap;
    List<String> answer;
    int strLen;
    public List<String> letterCombinations(String digits) {

        charMap = new ArrayList<>();
        answer = new ArrayList<>();
        charMap.add(List.of('a','b','c'));
        charMap.add(List.of('d','e','f'));
        charMap.add(List.of('g','h','i'));
        charMap.add(List.of('j','k','l'));
        charMap.add(List.of('m','n','o'));
        charMap.add(List.of('p','q','r','s'));
        charMap.add(List.of('t','u','v'));
        charMap.add(List.of('w','x','y','z'));
        //need to parse the string to Integer digits
        
        if(digits.length()==0) return answer;
        strLen = digits.length();
        findCombination(digits, new StringBuilder(), 0);
        return answer;
    }

    private void findCombination(String digits, StringBuilder sb, int index){

        if(sb.length() == strLen) {
            answer.add(sb.toString());
            return;
        }
        int num = digits.charAt(index) - '0' - 2;
        for(int i=0;i<charMap.get(num).size();i++){
            sb.append(charMap.get(num).get(i));
            findCombination(digits, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}