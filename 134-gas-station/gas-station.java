class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int totalGas = 0;
        for(int i:gas) totalGas+=i;
        for(int i:cost) totalGas-=i;
        if(totalGas < 0) return -1;

        int currentGas = 0;
        int start = 0;
        for(int i=0;i<len;i++){
            currentGas += gas[i];
            currentGas -= cost[i];

            if(currentGas < 0){
                start = i+1;
                currentGas = 0;
            }
        }
        return start;
    }
}