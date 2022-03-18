# leetcode 2116. Check if a Parentheses String Can Be Valid

- [문제 링크](https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/)

</br>

```java


class Solution {
    public boolean canBeValid(String s, String locked) {

        int n = s.length();

        if(n%2 == 1)
            return false;

        // range of open bracket
        int min = 0;
        int max = 0;

        for(int i=0; i < n; i++){

            if(locked.charAt(i) == '0'){
                min--;
                max++;
            }
            else{

                if(s.charAt(i) == '('){
                    min++;
                    max++;

                }
                else{
                    min--;
                    max--;
                }
            }

            if(max < 0)
                return false;

            min = min < 0 ? 0 : min;

        }

        return min == 0;
    }
}

```
