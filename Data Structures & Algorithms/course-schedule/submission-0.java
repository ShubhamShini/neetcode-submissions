class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        int[] state = new int[numCourses];
        // 0 = unvisited
        // 1 = visiting
        // 2 = processed

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(graph, state, i))
                    return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] state, int course) {

        state[course] = 1; // visiting

        for (int next : graph.get(course)) {

            if (state[next] == 1)
                return true; // cycle found

            if (state[next] == 0) {
                if (hasCycle(graph, state, next))
                    return true;
            }
        }

        state[course] = 2; // processed
        return false;
    }
}
