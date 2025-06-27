class Solution {
    Set<Integer> dupli = new HashSet<>();
    public boolean containsDuplicate(int[] nums) {
        for(int num: nums){
            if(dupli.contains(num)) return true;
            dupli.add(num);    
        }
        return false;
    }
}