class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sumOfSticks = 0;
        for(int match: matchsticks) sumOfSticks+=match;
        if(sumOfSticks % 4 != 0) return false;
        Arrays.sort(matchsticks);
        int len = matchsticks.length-1;
        int i = 0;
        int temp=0;
        while(i <= len){
            temp = matchsticks[i];
            matchsticks[i] = matchsticks[len];
            matchsticks[len] = temp;
            i++;
            len--;
        }
        int sideLen = sumOfSticks / 4;
        for(int match: matchsticks){
            if(sideLen < match) return false;
        }

        return dfsSquare(sideLen, matchsticks, 0, new int[4]);
    }

    private boolean dfsSquare(int sideLen, int[] matchsticks, int index, int[] sides){
        if(index == matchsticks.length) return true;

        int match = matchsticks[index];

        for(int i=0;i<4;i++){
            if((match + sides[i]) <= sideLen){
                // int before = sides[i];
                sides[i]+=match;
                if(dfsSquare(sideLen, matchsticks, index+1, sides)) return true;
                sides[i]-=match;
                if(sides[i] == 0) break;
            }
        }

        return false;
    }
}