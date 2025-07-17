class Solution {
    List<List<String>> answer;
    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        doPartition(s, 0, new ArrayList<>());
        return answer;
    }

    private void doPartition(String s, int startIndex, List<String> substrings){
        if(startIndex==s.length()){
            answer.add(new ArrayList<>(substrings));
            return;
        }

        for(int i=startIndex;i<s.length();i++){
            if(isPalin(s, startIndex, i) == true){
                substrings.add(s.substring(startIndex, startIndex + i-startIndex+1));
                doPartition(s, i+1, substrings);
                substrings.remove(substrings.size()-1);
            }
        }
    }

    private boolean isPalin(String s, int start, int end){
        if(start >= end) return true;
        if(s.charAt(start) != s.charAt(end)) return false;
        return isPalin(s, start+1, end-1);
    }
}