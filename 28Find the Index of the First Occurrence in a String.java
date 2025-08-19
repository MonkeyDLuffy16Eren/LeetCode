class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        while (i + needle.length() <= haystack.length()) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
              return i;
            }
            i++;   // don't forget to move to next position
        }
        return -1;
    }
}