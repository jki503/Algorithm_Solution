# leetcode 542. 01 Matrix

- [문제 링크](https://leetcode.com/problems/01-matrix/)

```java
class Solution {
    //상우하좌
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {-1,0,1,0};

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Point> q = new LinkedList<>();

        for(int y = 0; y < n; y++){
            for(int x = 0; x < m; x++){
                if(mat[y][x] == 0){
                    q.offer(new Point(x, y));
                }
                else{
                    mat[y][x] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            Point curr = q.poll();
            int x = curr.x;
            int y = curr.y;


            for(int i = 0 ; i < 4; i++){
                int xx = x + dx[i];
                int yy = y + dy[i];

                if(xx < 0 || xx >= m || yy < 0 || yy >=n){
                    continue;
                }

                if(mat[yy][xx] < 0){
                    q.offer(new Point(xx,yy));
                    mat[yy][xx] = mat[y][x] + 1;
                }
            }

        }

        return mat;
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
```
