class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freqMap.get(b) - freqMap.get(a));

        for(Integer key: freqMap.keySet()){
            pq.offer(key);
        }
        int[] ans = new int[k];
        int i=0;
        while(i<k){
            ans[i] = pq.poll();
            i++;
        }
        return ans;
    }
}