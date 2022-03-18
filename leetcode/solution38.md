# leetcode 316. Remove Duplicate Letters

- [문제 링크](https://leetcode.com/problems/remove-duplicate-letters/submissions/)

</br>

```java

import java.util.Stack;

class Solution {

    private static final int SIZE = 26;

    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();

        int[] cnt = new int[SIZE];
        boolean[] isDuplication = new boolean[SIZE];

        char[] arr = s.toCharArray();

        for(char c : arr)
            cnt[c-'a']++;

        for(char c : arr){

            cnt[c-'a']--;

            if(isDuplication[c-'a'])
                continue;

            while(!stack.empty() && stack.peek() > c && cnt[stack.peek()-'a'] >0)
                    isDuplication[stack.pop()-'a'] = false;

            stack.push(c);
            isDuplication[c-'a'] = true;
        }

        char[] result = new char[stack.size()];

        for(int i= result.length-1; i>= 0 ; i--)
            result[i] = stack.pop();

        return new String(result);
    }
}

```
