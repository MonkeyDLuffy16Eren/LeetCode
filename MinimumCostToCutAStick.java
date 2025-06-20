class Solution {
    public int minCost(int n, int[] cuts) {
        //n- length of sscale;
        int c = cuts.length;
        int[] newCuts = new int[c+2]; //for adding 0 and cuts.length at end of the arr[0,1,3,4,5,n] where n- length of scale(given)....*****;
        
        newCuts[0] =0;
        for(int i=0;i<c;i++){
            newCuts[i+1] = cuts[i];
        }
        
        newCuts[c+1] =n;
        Arrays.sort(newCuts);
        int d = newCuts.length;

        int[][] dp = new int[d][d];
        for(int i=0;i<d;i++){
            for(int j=0;j<d;j++){
                dp[i][j] =-1;
            }
        }
        return f(1,c,newCuts, dp);
    }
    private int f(int i,int j, int[] cuts, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int idx =i; idx<=j; idx++){
            int cost = cuts[j+1] - cuts[i-1] + f(i, idx-1, cuts,dp) + f(idx+1,j,cuts,dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}