# leetcode 8. String to Integer(atoi)

- [문제 링크](https://leetcode.com/problems/string-to-integer-atoi/)

</br>

```java

class Solution {
    public int myAtoi(String s) {

        boolean checkSign = true;

        int n = s.length();

        long result = 0;
        int num = 0;

        int i=0;

        while(i<n && s.charAt(i) == ' ')
            i++;

        if(i<n && s.charAt(i) == '-'){
            checkSign = false;
            i++;
        }else if(i<n && s.charAt(i) == '+')
            i++;

        while(i<n){

            char curr = s.charAt(i++);

            if(!(curr >='0' && curr <='9'))
                break;

            num = curr - '0';

            result = result * (long)10 + (long)num;
            if(checkSign && result >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(!checkSign &&  result*-1 <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

        }

        result = checkSign? result : -1 * result;

        return (int)result;
    }
}

```
