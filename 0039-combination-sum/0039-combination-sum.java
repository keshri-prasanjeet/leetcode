class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> allCombinations = new ArrayList<>();
        walkCombinations(candidates, 0, target, new ArrayList<>(), allCombinations);
        return allCombinations;
    }

    private void walkCombinations(int[] candidates, int start, int target, List<Integer> combination, List<List<Integer>> allCombinations){
        if(target == 0){
            allCombinations.add(new ArrayList<>(combination));
            return;
        }

        for(int i=start;i<candidates.length;i++){
            if(candidates[i] > target) break;
            combination.add(candidates[i]);
            walkCombinations(candidates, i, (target - candidates[i]), combination, allCombinations);
            combination.remove(combination.size()-1);
        }
    }
}