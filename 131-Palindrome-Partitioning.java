class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> allPartitions = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        dfs(s, allPartitions, partition, 0);
        return allPartitions;
    }

    private void dfs(String s, List<List<String>> allPartitions, List<String> partition, int start){
        if(start == s.length()){
            allPartitions.add(new ArrayList<>(partition));
            return;
        }

        for(int end = start; end<s.length();end++){
            if(isPalindrome(s, start, end)){
                partition.add(s.substring(start, end+1));
                dfs(s, allPartitions, partition, end+1);
                partition.remove(partition.size()-1);
            }
        }
        return;
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}