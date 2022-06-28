# leetcode 765. Couples Holding Hands

- [문제 링크](https://leetcode.com/problems/couples-holding-hands/)

```java
class Solution {
    public int minSwapsCouples(int[] row) {
        int answer = 0;
        int len = row.length;
        int[] location = new int[len];

        for(int i = 0; i < len; i++){
            int person = row[i];
            location[person] = i;
        }


        for(int i = 0; i < len - 1; i+=2){
            int first = row[i];
            int second = first + (first % 2 == 0 ? 1 : -1) ;
            if(row[i+1] == second)
                continue;

            int j = location[second];

            swap(row, i+1, j);
            location[row[i+1]] = i+1;
            location[row[j]] = j;

            answer++;
        }

        return answer;
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
```
