# leetcode 1239. Maximum Length of a Concatenated String with Unique Characters

- [문제 링크](https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/)

```java
class Solution {
    private int answer = 0;

    public int maxLength(List<String> arr) {
        backTracking("", 0, arr);
        return answer;
    }

    private void backTracking(String current, int idx, List<String> arr){
        answer = Math.max(answer, current.length());

        for(int i = idx; i < arr.size(); i++){
            String concatenation = current + arr.get(i);
            if(!isValid(concatenation)){
                continue;
            }
            backTracking(concatenation, i + 1, arr);
        }
    }

    private boolean isValid(String str){
        char[] arr = str.toCharArray();
        int[] map = new int[26];
        for(char c : arr){
            map[c - 'a']++;
            if(map[c - 'a'] == 2){
                return false;
            }
        }

        return true;
    }
}
```
