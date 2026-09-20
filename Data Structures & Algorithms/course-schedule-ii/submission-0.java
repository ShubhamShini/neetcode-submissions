class Solution {
    List<Integer> result = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] preq: prerequisites) {
            graph.get(preq[1]).add(preq[0]);
        }

        int[] visited = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i] == 0) {
                if(hasLoop(i,visited, graph)) return new int[0];
            }
        }

        Collections.reverse(result);

        int[] ans = new int[numCourses];

        for(int i=0;i<numCourses;i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    boolean hasLoop(int ind, int[] visited, List<List<Integer>> graph) {
        if(visited[ind] ==1) return true;

        visited[ind] = 1;

        for(int next: graph.get(ind)) {
            if(visited[next] == 1) return true;

            if(visited[next] == 0) {
                if(hasLoop(next, visited,graph)) return true;
            }
        }
        visited[ind] =2;
        result.add(ind);
        return false;
    }
}
