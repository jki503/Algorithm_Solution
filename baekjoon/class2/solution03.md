# [class2] 백준 9012 괄호

- [문제 링크](https://www.acmicpc.net/problem/9012)

</br>

```java

import java.util.Stack;
import java.io.*;

class Main{
    public static void main (String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            String currInput = br.readLine();

            if(checkBracket(currInput))
                sb.append("YES");
            else
                sb.append("NO");

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean checkBracket(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length(); i++){
            char currChar = s.charAt(i);

            if(currChar == '('){
                stack.push(currChar);
            }
            else{
                // 스택이 비어있거나
                if(stack.empty())
                    return false;
                // 스택의 top이 '('이 아니면 false
                if(stack.peek() != '(')
                    return false;
                stack.pop();
            }
        }

        // 비어 있으면 올바른 괄호 문장
        if(stack.empty())
            return true;
        else
            return false;

    }
}

```
