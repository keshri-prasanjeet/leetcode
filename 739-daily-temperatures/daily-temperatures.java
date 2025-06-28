class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[temperatures.length];
        st.push(0);
        for(int i=0;i<temperatures.length-1;i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i+1]){
                Integer pop = st.pop();
                answer[pop] = i+1-pop;
            }
            st.push(i+1);
        }
        return answer;
    }
}