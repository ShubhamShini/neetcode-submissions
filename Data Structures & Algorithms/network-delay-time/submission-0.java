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

        // {node, time}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int currentTime = current[1];

            // Ignore outdated entry
            if (currentTime > dist[node]) {
                continue;
            }

            // Traverse all neighbours
            for (int[] edge : graph.get(node)) {

                int nextNode = edge[0];
                int travelTime = edge[1];

                int newTime = currentTime + travelTime;

                // Found a shorter path
                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;

                    pq.offer(new int[]{nextNode, newTime});
                }
            }
        }

        // Find the time when the LAST node receives the signal
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}