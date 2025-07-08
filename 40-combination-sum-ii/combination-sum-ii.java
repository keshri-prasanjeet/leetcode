class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        answer = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        findCombination(candidates, target, combination, 0);
        return answer;
    }

    private void findCombination(int[] candidates, int target, List<Integer> combination, int startIndex){
        if(target < 0) return;
        if(target == 0){
            answer.add(new ArrayList<>(combination));
        }
        for(int i=startIndex; i<candidates.length;i++){
            if(i > startIndex && i < candidates.length && candidates[i] == candidates[i-1]) continue;
            // if i > startIndex  and i am same as previous then skip me becasue the previous was already added recursed, removed and i was added again
            // you already added 1 ... did the recursion and got all possible now again 1 at the start is double
            if(i == candidates.length) break;
            combination.add(candidates[i]);
            findCombination(candidates, target - candidates[i], combination, i+1);
            combination.remove(combination.size()-1);
        }
    }
}