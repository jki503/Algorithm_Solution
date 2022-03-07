# 백준 class 2 팰린드롬수(1259)

- [문제 링크](https://www.acmicpc.net/problem/1259)

</br>

```java

import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        while(true){

            String input = br.readLine();

            // 탈출 조건
            if(input.equals("0"))
                break;

            boolean checkPall = true;
            int n = input.length();

            for(int i=0; i < n/2; i++){

                if(input.charAt(i) != input.charAt(n-1-i)){
                    checkPall = false;
                    break;
                }

            }

            if(checkPall)
                sb.append("yes");
            else
                sb.append("no");

            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}

```
