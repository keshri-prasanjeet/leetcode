class Solution {
    List<List<String>> answer;
    public List<List<String>> partition(String s) {
        //partition a string into a group of substrings such that each substring in that group is a palindrome
        // aab -> [a, a, b], [aa, b]

        answer = new ArrayList<>();
        fps(s, new ArrayList<>(), 0);
        return answer;
    }

    private void fps(String s, List<String> substrings, int index){
        if(index == s.length()){
            answer.add(new ArrayList<>(substrings));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s, index, i)){
                substrings.add(s.substring(index, i+1));
                fps(s, substrings, i+1);
                substrings.remove(substrings.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str, int l, int r){
        while(l <= r){
            if(str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }
}