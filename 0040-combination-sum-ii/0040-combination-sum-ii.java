class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(candidates, target, 0, new ArrayList<>());
        return answer;
    }

    private void findCombination(int[] candidates, int target, int startIndex, List<Integer> combination){
        if(target == 0){
            answer.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i=startIndex;i<candidates.length;i++){
            
            if(i > startIndex && candidates[i] == candidates[i-1]) continue; // not attempting duplicate nums
            if(candidates[i] > target) break;//we are too far, cant get a solution here
            combination.add(candidates[i]);
            findCombination(candidates, target-candidates[i], i+1, combination);
            combination.remove(combination.size()-1);
        }
    }
}