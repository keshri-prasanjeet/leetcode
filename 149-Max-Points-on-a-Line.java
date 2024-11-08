class Solution {
    public int maxPoints(int[][] points) {
        int maxPoints = 1;
        int numPoints = points.length;
        for(int i=0;i<numPoints;i++){
            Map<String, Integer> lineMap = new HashMap<>();
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j=i+1;j<numPoints;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int deltaX = x2-x1;
                int deltaY = y2-y1;

                int gcd = gcd(deltaX, deltaY);

                String lineKey = (deltaX/gcd) + \^\ + (deltaY/gcd);

                lineMap.put(lineKey, lineMap.getOrDefault(lineKey,0)+1);

                maxPoints = Math.max(maxPoints, lineMap.get(lineKey)+1);
            }
        }

        return maxPoints;
    }

    private int gcd(int x, int y){
        while(y!=0){
            int temp = y;
            y = x%y;
            x = temp;
        }
        return x;
    }
}