class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) +1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freqMap.get(b) - freqMap.get(a));
        int[] answer = new int[k];
        int i = 0;
        for(Integer key: freqMap.keySet()){
            pq.offer(key);
        }
        while(i<k){
            answer[i] = pq.poll();
            i++;
        }
        return answer;
    }
}