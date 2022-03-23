# leetcode 991. Broken Calculator

- [문제 링크](https://leetcode.com/problems/broken-calculator/submissions/)

</br>

```java

class Solution {
    public int brokenCalc(int startValue, int target) {

        int result = 0;

        while(true){

            if(startValue >= target){
                result += startValue - target;
                break;
            }

            if(target % 2 == 0)
                target /= 2;
            else
                target += 1;

            result++;
        }

        return result;
    }
}

```
