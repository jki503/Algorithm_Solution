# leetcode 1249. Minimum Remove to Make Valid Parentheses

- [문제 링크](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/submissions/)

</br>

```java

import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack();

        char[] arr = s.toCharArray();

        for(int i=0;i<arr.length;i++){

            char curr = arr[i];

            if(curr == '(')
                stack.push(i);
            else if(curr == ')'){

                if(stack.empty())
                    arr[i] = ' ';
                else
                    stack.pop();
            }

        }

        while(!stack.empty())
            arr[stack.pop()] = ' ';

        return new String(arr).replace(" ","");

    }
}

```
