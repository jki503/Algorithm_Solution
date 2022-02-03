# [class2] 백준 10773 제로

- [문제 링크](https://www.acmicpc.net/problem/10773)

</br>

```java

import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0;i<K;i++){
            int currNum = Integer.parseInt(br.readLine());

            if(currNum == 0){
                stack.pop();
            }
            else{
                stack.push(currNum);
            }
        }

        while(!stack.empty()){
            result+=stack.pop();
        }
        System.out.println(result);
    }

}

```
