class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(combination, candidates, 0, target);
        return answer;
    }

    private void findSum(List<Integer> combination, int[] candidates, int startIndex, int target){
        if(target == 0){
            answer.add(new ArrayList<>(combination));
            return;
        }

        for(int i=startIndex;i<candidates.length;i++){
            if(i > startIndex && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            combination.add(candidates[i]);
            findSum(combination, candidates, i+1, target-candidates[i]);
            combination.remove(combination.size()-1);
        }
    }
}