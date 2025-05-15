Q424:-
    Longest Repeating Character Replacement
    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
    Return the length of the longest substring containing the same letter you can get after performing the above operations.
    
Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Approach:-
In this solution, we try every possible substring starting at index i and ending at j, and we count the frequency of characters in that window. The goal is to find the maximum length of a substring where we can replace at most k characters to make all characters the same.

🔁 Logic:
Iterate over all substrings using two nested loops (i and j).

For each window [i...j], use a fixed-size frequency array of size 26 (for 'A' to 'Z').

Calculate how many characters need to be changed:
changes = (window size) - (frequency of most common character)

If changes <= k, update the maximum length.

*code:--
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen=0;
        int maxFreq=0;
        for(int i=0;i<n;i++){
            int[] arr= new int[26];
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'A']++;
                maxFreq = Math.max(maxFreq, arr[s.charAt(j)-'A']);
                int changes = (j-i+1)- maxFreq;

                if(changes <= k){
                    maxLen = Math.max(maxLen,j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxLen;
    }
} 
⏱️ Time Complexity:
O(n²): Two nested loops for all possible substrings.

Inner operations (frequency count and max update) take O(1) because the alphabet size is constant (26 letters).

🧠 Space Complexity:
O(1): The frequency array arr[26] is of constant size.
