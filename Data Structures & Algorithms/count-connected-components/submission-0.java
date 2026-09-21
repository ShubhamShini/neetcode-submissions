class Solution {
    public int countComponents(int n, int[][] edges) {
        int count =0;
        boolean[] visited = new boolean[n];

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(i, visited,graph);
                count++;
            }
        }
        return count;
    }

    void dfs(int curr, boolean[] visited, List<List<Integer>> graph) {
        visited[curr] = true;

        for(int n : graph.get(curr)) {
            if(!visited[n]) {
                dfs(n,visited,graph);
            }
        }
    }
}
