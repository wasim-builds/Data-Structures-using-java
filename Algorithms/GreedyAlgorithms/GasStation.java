/**
 * Gas Station (LeetCode 134)
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startPosition = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];
            
            if (currentGas < 0) {
                startPosition = i + 1;
                currentGas = 0;
            }
        }
        
        return totalGas >= totalCost ? startPosition : -1;
    }
}
