class Solution {
    public int rob(int[] nums) {
        // if only 1 element just return it...
        if(nums.length<2){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        //memoize max loot at first 2 indices..
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];

    }
}
//bigo n time and sapce as well...