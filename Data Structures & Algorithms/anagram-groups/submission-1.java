class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        str -> {
                            char[] ch = str.toCharArray();
                            Arrays.sort(ch);
                            return new String(ch);
                        }
                ))
                .values()
                .stream()
                .collect(Collectors.toList());

    }
}
