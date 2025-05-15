class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0, l = 0, r = 0;
        int maxFreq = 0;
        int[] arr = new int[26];

        while (r < n) {
            arr[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, arr[s.charAt(r) - 'A']);

            if ((r - l + 1) - maxFreq > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }

            if ((r - l + 1) - maxFreq <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }

        return maxLen;
    } 
}
