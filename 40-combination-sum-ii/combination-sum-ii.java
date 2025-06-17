class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        doCombinationSum(candidates, target, combination, 0);
        return answer;
    }
    private void doCombinationSum(int[] candidates, int target, List<Integer> combination, int startIndex){
        
        if(target == 0){
            answer.add(new ArrayList<>(combination));
            return;
        }

        for(int i=startIndex;i<candidates.length;i++){
            if(i> startIndex && candidates[i] == candidates[i-1]) continue;
            if(target < 0) break;
            combination.add(candidates[i]);
            doCombinationSum(candidates, target-candidates[i], combination, i+1);
            combination.remove(combination.size()-1);
        }
    }
}