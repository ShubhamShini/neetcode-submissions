class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];

            graph.get(source).add(new int[]{destination, travelTime});
        }

        // dist[i] = minimum time to reach node i
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int node = curr[0];
            int time = curr[1];

            if(time>dist[node]) continue;

            for(int[] edge: graph.get(node)) {
                int nextnode = edge[0];
                int nexttime = edge[1];
                int newtime = time + nexttime;
                if(newtime<dist[nextnode]) {
                    dist[nextnode] = newtime;
                    pq.offer(new int[]{nextnode,newtime});
                }
            }
        }
        int ans = 0;

        for(int i=1;i<=n;i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;

            ans = Math.max(ans,dist[i]);
        }
        return ans;

    }
}