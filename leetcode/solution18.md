# leetcode 387. First Unique Character in a String

- [문제 링크](https://leetcode.com/problems/first-unique-character-in-a-string/)

</br>

```java

class Solution {
    public int firstUniqChar(String s) {

        int[] arr = new int[128];

        for(char c : s.toCharArray())
            arr[c - 'a'] +=1;

        for(int i=0; i < s.length();i++)
            if(arr[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }
}

```
