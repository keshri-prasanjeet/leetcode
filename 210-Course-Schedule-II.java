class Solution {
    List<Integer> courseOrder;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> prerequisiteMap = new HashMap<>();
        courseOrder = new ArrayList<>();
        for(int i=0;i<prerequisites.length;i++){
            int cou = prerequisites[i][0];
            int pre = prerequisites[i][1];

            prerequisiteMap.putIfAbsent(cou, new ArrayList<>());
            prerequisiteMap.get(cou).add(pre);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> coursePath = new HashSet<>();
        
        for(int i=0;i<numCourses;i++){
            if(!dfsHelper(i, prerequisiteMap, visited, coursePath, numCourses)){
                return new int[0];
            }
        }
        int [] result = new int[numCourses];
        for(int i=0;i<numCourses; i++){
            result[i] = courseOrder.get(i);
        }
        return result;
    }

    private boolean dfsHelper(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visited, Set<Integer> coursePath, int numCourses){
        if(coursePath.contains(course)) return false;
        if(visited.contains(course)) return true;
        if(!preMap.containsKey(course)){
            courseOrder.add(course);
            visited.add(course);
            return true;
        }

        coursePath.add(course);
        List<Integer> preCourses = preMap.get(course);
        for(int preCourse:preCourses){
            if(!dfsHelper(preCourse, preMap, visited, coursePath, numCourses)) return false;
        }
        coursePath.remove(course);
        visited.add(course); 
        courseOrder.add(course);
        return true;
    }
}