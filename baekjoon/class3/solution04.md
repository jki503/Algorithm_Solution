# 백준 class 3 잃어버린 괄호(1541)

- [문제 링크](https://www.acmicpc.net/problem/1541)

</br>

```java

import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] expression = br.readLine().split("-");

        String[] first = expression[0].split("\\+");

        int result = 0;

        // - 이전은 더하기
        for(String num : first)
            result += Integer.parseInt(num);

        // - 이후는 모두 빼기
        for(int i=1;i<expression.length;i++){

            String[] nums = expression[i].split("\\+|-");

            for(String num : nums)
                result-=Integer.parseInt(num);

        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}

```
