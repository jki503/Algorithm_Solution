# [class2] 백준 4949 균형잡힌 세상

- 문제링크(https://www.acmicpc.net/problem/4949)

</br>

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            // 종료
            if (input.equals("."))
                break;

            if (checkedBalanced(input)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }


        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }


    public static boolean checkedBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);



            if (currentChar == '(' || currentChar == '[') {
                // 여는 괄호면 push
                stack.push(currentChar);
            } else if (currentChar == ')') {
                // 닫는 괄호면 검사
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() != '(') {
                    return false;
                }

                stack.pop();


            } else if (currentChar == ']') {
                // 닫는 괄호면
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }

}

```
