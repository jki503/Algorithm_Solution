# leetcode 9. Palindrome Number

- [문제 링크](https://leetcode.com/problems/palindrome-number/)

</br>

```java

class Solution {
    public boolean isPalindrome(int x) {

        char[] arr = Integer.toString(x).toCharArray();
        int n = arr.length;

        for(int i=0; i < n/2;i++){
            if(arr[i] != arr[n-1-i])
                return false;
        }

        return true;
    }
}

```
