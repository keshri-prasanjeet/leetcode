class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        doCombinationSum(answer, combination, k, n, 1);
        return answer;
    }

    private void doCombinationSum(List<List<Integer>> answer, List<Integer> combination, int k, int target, int start){
        if(target < 0) return;
        if(combination.size() == k){
            if(target == 0){
                answer.add(new ArrayList<>(combination));
            }
            return;
        }

        for(int i=start;i<10;i++){
            //can do a preemptive check of target-i >=0
            combination.add(i);
            doCombinationSum(answer, combination, k, target-i, i+1);
            combination.remove(combination.size()-1);
        }
    }
}