class Solution {
    List<List<String>> answer;
    public List<List<String>> partition(String s) {
        //partition a string into a group of substrings such that each substring in that group is a palindrome
        // aab -> [a, a, b], [aa, b]

        answer = new ArrayList<>();
        List<String> substrings = new ArrayList<>();
        fps(s, substrings, 0);
        return answer;
    }

    private void fps(String s, List<String> substrings, int index){
        if(index == s.length()){
            answer.add(new ArrayList<>(substrings));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=index;i<s.length();i++){
            sb.append(s.charAt(i));
            String curr = sb.toString();
            if(isPalindrome(curr)){
                substrings.add(curr);
                fps(s, substrings, i+1);
                substrings.remove(substrings.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str){
        int l = 0;
        int r = str.length()-1;
        while(l <= r){
            if(str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }
}