Q 930. Binary Subarrays With Sum
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
A subarray is a contiguous part of the array.
Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
#####........#####
🧠 Approach:
We use a two-pass sliding window technique via a helper function:

Count the number of subarrays with sum at most goal

Count the number of subarrays with sum at most goal - 1

Their difference gives the number of subarrays with exactly sum = goal

This trick works only for binary arrays (0s and 1s) because sum is monotonically increasing when we add 1s and doesn't fluctuate.
    
 Code:-
    class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        int n = nums.length;
        int l = 0, r = 0, sum = 0, count = 0;

        while (r < n) {
            sum += nums[r];
            while (l <= r && sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += r - l + 1;  
            r++;
        }

        return count;
    }
}
⏱️ Time Complexity:
O(n) where n is the length of the array.

Each element is processed at most twice (once by r, once by l).

📦 Space Complexity:
O(1) extra space (constant space used).
