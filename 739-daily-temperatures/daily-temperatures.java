class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                Integer pop = st.pop();
                answer[pop] = i-pop;
            }
            st.push(i);
        }
        return answer;
    }
}