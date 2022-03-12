# leetcode 13. Roman to Integer

- [문제 링크](https://leetcode.com/problems/roman-to-integer/)

</br>

```java

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {

        int num=0;

        Map<Character,Integer> rMap = new HashMap<>(){{
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }};

        int n = s.length();

        for(int i=0;i<n-1;i++){

            int curr = rMap.get(s.charAt(i));
            int next = rMap.get(s.charAt(i+1));

            // check 9 90 900 4 40 400
            if(curr >= next){
                num+=curr;
            }
            else
                num-=curr;

        }

        num += rMap.get(s.charAt(n-1));

        return num;
    }
}

```
