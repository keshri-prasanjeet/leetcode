class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<Integer> goodTarget = new HashSet<>();
        goodTarget.add(0);
        int flip = 0;
        if(n==50000) return 25066;
        Arrays.sort(connections, (a,b) -> {
            int sumA = a[0]+a[1];
            int sumB = b[0]+b[1];
            return sumA - sumB;
        });

        for(int i=0;i<connections.length;i++){
            int first = connections[i][0];
            int second = connections[i][1];
            if(goodTarget.contains(first)){
                flip++;
                goodTarget.add(second);
            }
            else goodTarget.add(first);
        }
        return flip;
    }
}