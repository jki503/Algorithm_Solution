# 백준 class 2 분해합(2231)

- [문제 링크](https://www.acmicpc.net/problem/2231)

</br>

```java

import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = N-54 ; i < N ; i++){

            int num = i;
            int digit=0;

            while(num!=0) {
                digit += num % 10;
                num /= 10;
            }
            if(i+ digit == N){
                result = i;
                break;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

}

```
