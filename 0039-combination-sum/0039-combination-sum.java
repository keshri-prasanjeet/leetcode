class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        Arrays.sort(candidates);
        for(int i=0;i<=target;i++){
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(new ArrayList<>());
        for(int candidate: candidates){
            for(int i=candidate;i<=target;i++){
                for(List<Integer> prev: dp.get(i-candidate)){
                    List<Integer> newSum = new ArrayList<>(prev);
                    newSum.add(candidate);
                    dp.get(i).add(newSum);
                }
            }
        }
        return dp.get(target);
    }
}