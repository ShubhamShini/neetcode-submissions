class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for(String word:words) {
            for(char c: word.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];

            int length = Math.min(s1.length(),s2.length());
            boolean diff = false;

            for(int j=0;j<length;j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if(c1 != c2) {
                    diff = true;
                    map.get(c1).add(c2);
                    break;
                }
            }
            if(diff == false && s1.length()>s2.length()) return "";
        }
        Map<Character, Integer> indegree = new HashMap<>();
        for(char c: map.keySet()) {
            indegree.put(c,0);
        }
        for(char c: map.keySet()) {
            for(char next: map.get(c)) {
                indegree.put(next,indegree.get(next)+1);
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(char c : map.keySet()) {
            if(indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        StringBuilder result = new StringBuilder();

        while(!queue.isEmpty()) {
            char c = queue.poll();

            result.append(c);
            for(char next: map.get(c)) {
                indegree.put(next,indegree.get(next)-1);
                if(indegree.get(next) ==0) {
                    queue.offer(next);
                }
            }
        }
        if(result.length() != map.size()) return "";

        return result.toString();
    }
}
