# leetcode 71. Simplify Path

- [문제 링크](https://leetcode.com/problems/simplify-path/)

</br>

```java

class Solution {
    public String simplifyPath(String path) {

        String[] s = path.split("/");
        StringBuilder sb = new StringBuilder();

        int up=0;

        for(int i = s.length - 1; i >= 0; i--){
            if(s[i].equals(".") || s[i].equals(""))continue;
            else if(s[i].equals("..")) up++;
            else if(up>0) up--;
            else sb.insert(0,"/"+ s[i]);
        }

        if(sb.length() == 0)
            return "/";

        return sb.toString();
    }
}

```
