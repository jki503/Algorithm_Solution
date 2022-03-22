# leetcode 1663. Smallest String With A Given Numeric Value

- [문제 링크](https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/)

</br>

```java

class Solution {
    public String getSmallestString(int n, int k) {

        char[] chars = new char[n];

        for(int i = n - 1 ; i >= 0; i--){

            int idx = 26 > k - i ? k - i : 26;
            chars[i] = (char)('a' + idx -1);
            k-=idx;
        }


        return new String(chars);
    }
}

```
