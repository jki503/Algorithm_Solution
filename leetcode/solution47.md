# leetcode 1007. Minimum Domino Rotations For Equal Row

- [문제 링크](https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/)

</br>

```java

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int result = Integer.MAX_VALUE;
        int n = tops.length;

        for(int i=1; i <= 6; i++){

            boolean isPossible = true;

            int cnt = 0;
            int tCnt = 0;
            int bCnt = 0;

            for(int j=0; j < n; j++){

                if(tops[j] != i && bottoms[j] != i){
                    isPossible = false;
                    break;
                }
                else if(tops[j] == i && bottoms[j] != i)
                    tCnt++;
                else if(tops[j] != i && bottoms[j] == i)
                    bCnt++;
                else
                    continue;


            }

            if(!isPossible)
                continue;

            cnt = tCnt > bCnt ? bCnt : tCnt;

            if(result > cnt)
                result = cnt;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}


```
