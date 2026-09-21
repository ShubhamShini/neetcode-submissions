class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length) return false;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if(!dfs(0,-1,visited,graph)) return false;

        for(boolean v: visited) {
            if(!v) return false;
        }

        return true;
    }

    boolean dfs(int curr, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[curr] = true;
        for(int neighbour : graph.get(curr)) {
            if(!visited[neighbour]) {
                if(!dfs(neighbour, curr, visited, graph)) return false;
            }else if(neighbour != parent) return false;
        }
        return true;

    }
}
