import java.util.*;

class Solution {
    private String getFrequencyString(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            freq[c - 'a']++;
        }
        StringBuilder frequencyString = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            frequencyString.append(freq[i]);
            frequencyString.append('#'); // safer delimiter instead of index/char
        }
        return frequencyString.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> frequencyStringMap = new HashMap<>();
        for (String str : strs) {
            String frequencyString = getFrequencyString(str);

            // if the freq string is already present, add
            if (frequencyStringMap.containsKey(frequencyString)) {
                frequencyStringMap.get(frequencyString).add(str);
            } else {
                // create a new list
                List<String> strList = new ArrayList<>();
                strList.add(str); 
                frequencyStringMap.put(frequencyString, strList);
            }
        }
        return new ArrayList<>(frequencyStringMap.values()); 
    }
}
