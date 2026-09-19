class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] preq: prerequisites) {
            graph.get(preq[1]).add(preq[0]);
        }

        int[] visited = new int[numCourses];

        for(int i=0;i<numCourses;i++) {
            if(visited[i] == 0) {
                if(hasLoop(graph,visited,i)) return false;
            }
        }
        return true;
    }

    boolean hasLoop(List<List<Integer>> graph, int[] visited, int course) {
        visited[course] = 1;
        for(int next: graph.get(course)) {
            if(visited[next] ==1) {
                return true;
            }
            if(visited[next] == 0){
                if(hasLoop(graph,visited,next)) 
                    return true;
            }
        }
        visited[course] = 2;
        return false;
    }
}
