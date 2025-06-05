class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> roomQ = new LinkedList<>();
        List<Integer> zeroThRoom = rooms.get(0);
        for(int i=0;i<zeroThRoom.size();i++){
            roomQ.offer(zeroThRoom.get(i));
        }
        visited.add(0);
        while(!roomQ.isEmpty()){
            int top = roomQ.poll();
            if(!visited.contains(top)){
                List<Integer> toBeVisited = rooms.get(top);
                visited.add(top);
                for(int i=0;i<toBeVisited.size();i++){
                    if(!visited.contains(toBeVisited.get(i))){
                        roomQ.offer(toBeVisited.get(i));
                    }
                }
            }
        }
        if(visited.size() == rooms.size()) return true;
        return false;
    }
}