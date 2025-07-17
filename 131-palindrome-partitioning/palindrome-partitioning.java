class Solution {
    List<List<String>> answer;
    Boolean[][] palinMap;
    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        int len = s.length();
        palinMap = new Boolean[len][len];
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
        if(palinMap[start][end]!=null) return palinMap[start][end];
        if(s.charAt(start) != s.charAt(end)) return palinMap[start][end] = false;
        return palinMap[start][end] = isPalin(s, start+1, end-1);
    }
}