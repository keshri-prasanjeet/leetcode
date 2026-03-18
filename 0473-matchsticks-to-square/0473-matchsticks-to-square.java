class Solution {
    public boolean makesquare(int[] matchsticks) {
        //four sides of a square must be same 
        //find target that each side must sum to
        //do dfs to populate each side
        //if all sides are populated return true

        int sum = 0;
        for(int matchstick: matchsticks){
            sum+=matchstick;
        }
        if(sum%4!=0) return false;
        int sidesum = sum/4;
        Arrays.sort(matchsticks);

         for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];
            matchsticks[matchsticks.length - 1 - i] = temp;
        }

        for(int matchstick: matchsticks){
            if(matchstick > sidesum) return false;
        }

        return makeSquareDFS(matchsticks, sidesum, 0, new int[4]);
    }

    private boolean makeSquareDFS(int[] matchsticks, int sideSum, int index, int[] sides){
        if(index == matchsticks.length) return true;
        int matchstick = matchsticks[index];
        for(int i=0;i<4;i++){
            if((sides[i] + matchstick) <= sideSum){
                sides[i]+=matchstick;
                if(makeSquareDFS(matchsticks, sideSum, index+1, sides)) return true;
                sides[i]-=matchstick;
                if(sides[i] == 0) break;
            }
        }
        return false;
    }
}