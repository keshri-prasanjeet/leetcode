class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> allPartitions = new ArrayList<>();
        backtrack(allPartitions, new ArrayList<>(), s, 0);
        return allPartitions;
    }

    private void backtrack(List<List<String>> allPartitions, List<String> partition, String s, int start){
        if(start == s.length()){
            allPartitions.add(new ArrayList<>(partition));
            return;
        }

        for(int end=start; end < s.length(); end++){
            String substring = s.substring(start, end+1);
            if(isPalindrome(substring)){
                partition.add(substring);
                backtrack(allPartitions, partition, s, end+1);
                partition.remove(partition.size()-1);
            }
        }
        return;
    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right= s.length()-1;
        while(left <=right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}