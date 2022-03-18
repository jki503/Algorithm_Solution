# leetcode 678. Valid Parenthesis String

- [문제 링크](https://leetcode.com/problems/valid-parenthesis-string/)

</br>

```java

class Solution {
    public boolean checkValidString(String s) {

        // range of open bracket
        int min = 0;
        int max = 0;

        for(char c : s.toCharArray()){

            if(c == '('){
                min++;
                max++;
            }
            else if(c == ')'){
                min--;
                max--;
            }
            else {
                min--;
                max++;
            }

            if(max < 0)
                return false;

            min = min < 0 ? 0 : min;
        }

        return min == 0;
    }
}

```
