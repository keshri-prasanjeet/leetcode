class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] ans = new int[spells.length];
        int index = 0;
        for(int spell: spells){
            int left = 0;
            int right = n-1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if((long) potions[mid] * spell >= success){
                    right = mid-1;
                }
                else left = mid +1;
            }
            ans[index++] = n-left;
        }
        return ans;
    }
}