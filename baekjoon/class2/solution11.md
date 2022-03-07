# 백준 class 2 스택수열(1874)

- [문제 링크](https://www.acmicpc.net/problem/1874)

</br>

```java

import java.io.*;
import java.util.Stack;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>(); // 스택 수열
        StringBuilder sb = new StringBuilder(); // 결과 저장
        int curr = 0;

        for(int i=1 ; i < N + 1; i++){

            if(arr[curr] != i){
                stack.push(i);
                sb.append('+').append("\n");
            }
            else{

                sb.append('+').append("\n")
                    .append('-').append("\n");

                curr++;

                // 반복해서 꺼내기
                while(!stack.empty()){

                    if(arr[curr] == stack.peek()){
                        stack.pop();
                        sb.append('-').append("\n");
                        curr++;
                    }
                    else
                        break;

                }
            }

        }

        if(!stack.empty())
            System.out.println("NO");
        else
            System.out.println(sb.toString());


    }

}


```
