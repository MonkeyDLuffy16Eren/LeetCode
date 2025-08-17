class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }

        int n = gas.length;
        int index = 0;
        int currGas = 0;

        for (int i = 0; i < n; i++) {
            currGas += gas[i] - cost[i];
            if (currGas < 0) {
                index = i + 1;
                currGas = 0;
            }
        }
        return index;
    }
}
