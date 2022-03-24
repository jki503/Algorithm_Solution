# leetcode 881. Boats to Save People

```java

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int result=0;
        int start = 0;
        int end = people.length-1;

        while(start <= end){

            if(people[start] + people[end] <= limit)
                start++;

            end--;
            result++;
        }

        return result;
    }
}

```
