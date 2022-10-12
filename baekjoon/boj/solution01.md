# 백준 1049 기타줄

- [문제 링크](https://www.acmicpc.net/problem/1049)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int minPackage = Integer.MAX_VALUE;
    int minOne = Integer.MAX_VALUE;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int currPackage = Integer.parseInt(st.nextToken());
      int currOne = Integer.parseInt(st.nextToken());

      minPackage = minPackage > currPackage ? currPackage : minPackage;
      minOne = minOne > currOne ? currOne : minOne;
    }

    int priceWithPackage = (n / 6) * minPackage + Math.min(minPackage, (n % 6) * minOne);
    int priceWithOne = n * minOne;
    int answer = Math.min(priceWithPackage, priceWithOne);

    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
  }

}

```
