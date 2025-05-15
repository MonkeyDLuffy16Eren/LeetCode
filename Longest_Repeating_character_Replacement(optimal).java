Q424:- Longest Repeating Character Replacement
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4

 

🔠 Longest Repeating Character Replacement — Sliding Window Approach
Problem: Given a string s and an integer k, you can replace at most k characters in the string so that all characters in a substring become the same. Return the length of the longest such substring.

📍 Leetcode Link: Longest Repeating Character Replacement

💡 Approach: Sliding Window
We use a sliding window to represent a range in the string where at most k characters can be changed to make all characters the same.

Key Idea:-
. Keep track of character frequencies in the current window.
. Maintain maxFreq — frequency of the most common character.
. If (window size - maxFreq) > k, shrink the window from the left.
. Keep updating the maximum window length.
    
code:--
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
⏱️ Time Complexity
O(n): Each character is added and removed from the window at most once.

r moves from 0 to n-1, and l moves forward when needed.

No nested loops or recomputation of max in worst-case.

💾 Space Complexity
O(1):
We use a fixed-size integer array arr[26] for capital English letters A–Z.

