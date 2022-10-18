# 백준 소수의 연속합(1644)

- [문제 링크](https://www.acmicpc.net/problem/1644)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int answer = 0;
    int n = Integer.parseInt(br.readLine());
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }

    int l = 0;
    int r = 0;
    int sum = 0;
    while (r < primes.size()) {
      if (sum < n) {
        sum += primes.get(r++);
      }

      if (sum > n) {
        sum -= primes.get(l++);
      }

      if (sum == n) {
        sum -= primes.get(l++);
        answer++;
      }
    }

    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
  }

  private static boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }

    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
```
