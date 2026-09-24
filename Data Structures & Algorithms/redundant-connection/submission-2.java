class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];

            boolean[] visited = new boolean[n+1];
            
            if(dfs(a,b,visited,graph))
                return edge;

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return new int[0];
    }

    boolean dfs(int curr, int target, boolean[] visited, List<List<Integer>> graph) {
        if(curr == target) return true;

        visited[curr] = true;

        for(int next : graph.get(curr)) {
            if(!visited[next]) {
                if(dfs(next,target,visited,graph)) 
                    return true;
            }
        }

        return false;
    }
}
