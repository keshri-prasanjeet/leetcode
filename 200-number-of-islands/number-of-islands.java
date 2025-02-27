class Solution {

    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        Queue<Pair> islandQueue = new LinkedList<>();
        Set<String> landSet = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    //check if this is already used up
                    String key = i + "," + j;
                    // System.out.println(key + " is 1 found");
                    if(!landSet.contains(key)){
                        // System.out.println(key + " is newly found");
                        //new found land
                        count++;
                        islandQueue.offer(new Pair(i,j));
                        landSet.add(key);
                        while(!islandQueue.isEmpty()){
                            Pair top = islandQueue.poll();
                            String k = "";
                            if(top.x-1 >= 0 && grid[top.x-1][top.y]=='1'){
                                k = (top.x-1) + "," + top.y;
                                if(!landSet.contains(k)){
                                    islandQueue.offer(new Pair((top.x-1),top.y));
                                    landSet.add(k);
                                    // System.out.println(k + " is neighbor 1 found");
                                }
                            }
                            if(top.x+1 < m && grid[top.x+1][top.y]=='1'){
                                k = (top.x+1) + "," + top.y;
                                if(!landSet.contains(k)){
                                    islandQueue.offer(new Pair((top.x+1),top.y));
                                    landSet.add(k);
                                    // System.out.println(k + " is neighbor 1 found");
                                }
                            }
                            if(top.y-1 >= 0 && grid[top.x][top.y-1]=='1'){
                                k = (top.x) + "," + (top.y-1);
                                if(!landSet.contains(k)){
                                    islandQueue.offer(new Pair((top.x),(top.y-1)));
                                    landSet.add(k);
                                    // System.out.println(k + " is neighbor 1 found");
                                }
                            }
                            if(top.y+1 < n && grid[top.x][top.y+1]=='1'){
                                k = (top.x) + "," + (top.y+1);
                                if(!landSet.contains(k)){
                                    islandQueue.offer(new Pair((top.x),(top.y+1)));
                                    landSet.add(k);
                                    // System.out.println(k + " is neighbor 1 found");
                                }
                            }
                        }
                        
                    }
                }
            }
        }
        return count;
    }
}