# leetcode 17. Letter Combinations of a Phone Number

- [문제 링크](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

</br>

```java

import java.util.ArrayList;

class Solution {

    List<String> result = new ArrayList<>();
    String[] keyPads = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0)
            return result;

        backTracking(new StringBuilder(), digits, 0);
        return result;
    }

    private void backTracking(StringBuilder sb, String digits, int idx){

        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }

        String s = keyPads[ (digits.charAt(idx) - '1')];

        for(int i=0;i<s.length();i++){
            backTracking(sb.append(s.charAt(i)),digits,idx+1);
            sb.setLength(sb.length()-1);
        }
    }
}

```
