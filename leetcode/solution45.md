# leetcode 978. Longest Turbulent Subarray

- [문제 링크](https://leetcode.com/problems/longest-turbulent-subarray/)

</br>

```java

class Solution {
    public int maxTurbulenceSize(int[] arr) {

        if(arr.length ==1)
            return 1;

        int cnt = 1;
        int max = 1;

        // true : arr[k] > arr[k+1] odd
        // false : arr[k] > arr[k+1] even
        boolean flag = false;

        for(int i=1 ; i < arr.length; i++){

            if(!flag){

                if(arr[i-1] > arr[i]){
                    cnt++;
                    flag = true;
                }
                else if(arr[i-1] < arr[i]) cnt=2;
                else cnt = 1;

            }
            else{
                if(arr[i-1] < arr[i]){
                    cnt++;
                    flag = false;
                }
                else if(arr[i-1] > arr[i]) cnt=2;
                else cnt = 1;

            }

            max = max < cnt ? cnt : max;
        }

        return max;
    }
}

```
