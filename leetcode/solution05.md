# leetcode 7. Reverse Integer

- [문제 링크](https://leetcode.com/problems/reverse-integer/)

</br>

```java

class Solution {
    public int reverse(int x) {

        boolean checkSign = x < 0 ? false : true;
        // converting sign
        if(!checkSign)
            x*= -1;

        int result = 0;

        while(x!=0){
            if(result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10)
                return 0;

            result = 10*result + x%10;
            x/=10;
        }

        //converting sing
        if(!checkSign)
            result*= -1;

        return result;
    }
}

```
