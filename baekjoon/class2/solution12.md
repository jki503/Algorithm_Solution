# 백준 class 2 수 찾기(1920)

- [문제 링크](https://www.acmicpc.net/problem/1920)

</br>

```java

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 1. 입력 1
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        // 2. 입력 2
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 3. 탐색
        for(int i=0;i<M;i++){

            boolean checkContain = false;

            int target = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N-1;
            int mid = 0;

            while(start <= end){

                mid = (start + end) / 2;

                if(target == arr[mid]){
                    checkContain = true;
                    break;
                }
                else if(target < arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if(checkContain)
                sb.append("1").append("\n");
            else
                sb.append("0").append("\n");

        }

        System.out.println(sb.toString());
    }

}

```
