# leetcode 946. Validate Stack Sequences

- [문제 링크](https://leetcode.com/problems/validate-stack-sequences/)

</br>

```java

import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int curr = 0;

        for(int i=0; i < pushed.length;i++){

            stack.push(pushed[i]);

            while(!stack.empty() && stack.peek() == popped[curr]){
                stack.pop();
                curr++;
            }


        }

        return stack.empty();
    }
}

```
