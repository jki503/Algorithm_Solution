# leetcode 58. Length of Last Word

- [문제 링크](https://leetcode.com/problems/length-of-last-word/)

</br>

```java

class Solution {
    public int lengthOfLastWord(String s) {

        int len = 0;

        for(int i= s.length()-1 ; i>=0; i--){
            if(s.charAt(i) == ' '){
                if(len > 0)
                    return len;
            }
            else
                len++;

        }

        return len;
    }
}

```
