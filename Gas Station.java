public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int left = 0;
        int start = 0;
        int  preGas = 0;
        for(int i=0;i<gas.length;i++) {
            left += gas[i]-cost[i];
            if(left < 0) {
                preGas += left;
                left = 0;
                start = i+1;
            }
        }
        if(start == gas.length)
            return -1;
        else if(left + preGas >= 0)
            return start;
        else
            return -1;
            
    }
}
