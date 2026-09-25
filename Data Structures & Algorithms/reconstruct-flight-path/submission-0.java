class Solution {
    Map<String,PriorityQueue<String>> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        
        for(List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            map.putIfAbsent(from,new PriorityQueue<>());
            map.get(from).offer(to);
        }

        dfs("JFK");

        Collections.reverse(result);

        return result;
    }

    void dfs(String airp) {
        PriorityQueue<String> curr = map.get(airp);

        while(curr != null && !curr.isEmpty()) {
            dfs(curr.poll());
        }

        result.add(airp);

    }
}
