class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numFreq = new HashMap<>();
        for(Integer num: nums){
            numFreq.put(num, numFreq.getOrDefault(num,0)+1);
        }
        Queue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for(Map.Entry<Integer,Integer> entry:numFreq.entrySet()){
            pq.add(entry);
        }

        int[] answer = new int[k];
        for(int i=0;i<k;i++){
            answer[i] = pq.poll().getKey();
        }

        return answer;
    }
}