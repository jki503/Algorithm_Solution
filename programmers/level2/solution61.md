# 프로그래머스 LEVEL2 위클리 챌린지 교점에 별 만들기

- [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/87377?language=java)

```java
import java.util.*;

class Solution {

    private static long minX = Long.MAX_VALUE;
    private static long maxX = Long.MIN_VALUE;
    private static long minY = Long.MAX_VALUE;
    private static long maxY = Long.MIN_VALUE;

    public String[] solution(int[][] line) {
        String[] answer = {};
        int n = line.length;

        Set<Point> pSet = new HashSet<>();

        for(int i = 0; i < n - 1; i++){
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];

            for(int j = i + 1; j < n; j++){
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long adbc = a * d - b * c;
                // 평행 판별
                if(adbc == 0){
                    continue;
                }

                long bfed = b * f - e * d;
                // x가 정수인지 판별
                if(bfed % adbc != 0){
                    continue;
                }

                long ecaf = e*c - a*f;
                // y가 정수인지 판별
                if(ecaf % adbc != 0){
                    continue;
                }

                long x = bfed / adbc;
                long y = ecaf / adbc;
                pSet.add(new Point(x,y));

                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }

        long height = maxY - minY + 1;
        long width = maxX - minX + 1;

        answer = new String[(int)height];
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < width; i++){
            sb.append(".");
        }

        Arrays.fill(answer, sb.toString());

        for(Point p : pSet){
            long y = maxY - p.y;
            long x = p.x - minX;

            answer[(int)y]= answer[(int)y].substring(0, (int)x)+"*"
                        +answer[(int)y].substring((int)x+1);
        }

        return answer;
    }

    public class Point{
        long x;
        long y;

        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
}
```
