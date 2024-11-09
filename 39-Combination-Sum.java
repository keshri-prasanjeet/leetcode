class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(allCombinations, cur, candidates, target, 0, 0);
        return allCombinations;
    }

    private void dfs(List<List<Integer>> allCombo, List<Integer> cur, int[] candidates, int target, int sum, int index){
        if(target==sum){
            allCombo.add(new ArrayList<>(cur));
            return;
        }

        if(target < sum){
            return;
        }

        for(int i=index;i<candidates.length;i++){
            cur.add(candidates[i]);
            sum+=candidates[i];
            dfs(allCombo, cur, candidates, target, sum, i);
            cur.remove(cur.size()-1);
            sum-=candidates[i];
        }
    }
}