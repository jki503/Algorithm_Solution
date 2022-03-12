# leetcode 134. Gas Station

- [문제 링크](https://leetcode.com/problems/gas-station/submissions/)

</br>

```java

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int station = -1;

        int n = gas.length;
        int currGas = 0;

        int gasSum = 0;
        int costSum = 0;

        for(int i = 0; i < n ; i++){
             gasSum += gas[i];
             costSum += cost[i];
        }

        if(gasSum < costSum)
            return station;

        int i = 0 ;

        while(i < n){

            currGas = gas[i] - cost[i];

            if(currGas >= 0)
                station = i;

            while(currGas >= 0 && i < n-1){
                i++;
                currGas += gas[i] - cost[i];

            }
            i++;
        }


        return station;
    }
}

```
