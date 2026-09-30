class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        
        if(digits.length() == 0) return ans;

        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        backtrack(digits, 0,"", mapping);

        return ans;
    }

    void backtrack(String digits, int index, String current, String[] mapping) {
        if(digits.length() == index) {
            ans.add(current);
            return;
        }

        String map = mapping[digits.charAt(index)-'0'];

        for(char c: map.toCharArray()) {
            backtrack(digits, index+1, current+c, mapping);
        }
    }
}
