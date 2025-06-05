class Solution {
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        visited[0] = true;
        visit(rooms, rooms.get(0));
        for(Boolean b:visited){
            if(b==false) return false;
        }
        return true;
    }

    private void visit(List<List<Integer>> rooms, List<Integer> currentRoom){
        for(int i:currentRoom){
            if(visited[i]) continue;
            visited[i] = true;
            visit(rooms, rooms.get(i));
        }
    }

}