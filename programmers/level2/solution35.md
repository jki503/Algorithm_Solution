# 프로그래머스 LEVEL 2 2019 KAKAO BLIND RECRUITMENT 오픈채팅방

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42888?language=java)

</br>

```java
import java.util.*;

class Solution {

    private static final String enterString = "님이 들어왔습니다.";

    private static final String leaveString = "님이 나갔습니다.";

    public String[] solution(String[] record) {
        List<String> logs = new ArrayList<>();
        Map<String, String> nickMap = new HashMap<>();

        for(String r : record){
            String[] rArr = r.split(" ");
            String cmd = rArr[0];
            String uid = rArr[1];

            if(cmd.equals("Leave")){
                logs.add(uid + leaveString);
                continue;
            }

            if(cmd.equals("Enter")){
                logs.add(uid + enterString);
            }

            String nickName = rArr[2];
            nickMap.put(uid, nickName);
        }

        String[] answer = new String[logs.size()];
        for(int i = 0 ; i < answer.length; i++){
            String log = logs.get(i);
            int idx = log.indexOf("님");
            String currId = log.substring(0,idx);

            answer[i] = log.replace(currId, nickMap.get(currId));
        }

        return answer;
    }
}
```
