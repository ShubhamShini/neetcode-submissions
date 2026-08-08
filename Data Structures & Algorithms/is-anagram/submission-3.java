class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character ,Integer> map = new HashMap<>();
        for(char i:s.toCharArray()) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) +1);
            }else 
                map.put(i,1);
        } 
        for(char ch: t.toCharArray()) {
            if(map.containsKey(ch) && map.get(ch)>0 ) {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)
                map.remove(ch);
            }else
                return false;
        }
        if(map.isEmpty())
        return true;
        return false;
    }
}
