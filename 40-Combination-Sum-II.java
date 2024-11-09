class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, allCombinations, combination, 0);
        return allCombinations;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> allCombinations, List<Integer> combination, int index){
        if(target == 0){
            allCombinations.add(new ArrayList<>(combination));
            return;
        }

        if(target < 0) return;

        for(int i=index;i<candidates.length;i++){

            if(i>index && candidates[i]==candidates[i-1]) continue;

            combination.add(candidates[i]);
            dfs(candidates, target - candidates[i], allCombinations, combination, i+1);
            combination.remove(combination.size()-1);
        }
        return;
    }
}