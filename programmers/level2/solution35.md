# 프로그래머스 LEVEL 2 2019 KAKAO BLIND RECRUITMENT 오픈채팅방

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42888?language=java)

</br>

```java

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

    String enterStr = "님이 들어왔습니다.";
    String leaveStr = "님이 나갔습니다.";

    List<String> logList;
    Map<String,String> nickMap;

    public String[] solution(String[] record) {
        String[] answer;

        this.logList = new ArrayList<>();
        this.nickMap = new HashMap<>();

        for(String rec : record){

            StringTokenizer st = new StringTokenizer(rec);

            String action = st.nextToken();
            String id = st.nextToken();
            String name = "";

            // Leave는 닉네임 없음
            if(!action.equals("Leave"))
                name = st.nextToken();

            // log 넣기
            recordLog(action, id, name);

        }

        // log에 uid -> nickname으로
        answer = changeNick();

        return answer;
    }

    public void recordLog(String action, String id, String name){
            if(action.equals("Enter")){
                nickMap.put(id,name);
                logList.add(id + enterStr);
            }
            else if(action.equals("Leave")){
                logList.add(id + leaveStr);
            }
            else if(action.equals("Change")){
                nickMap.put(id,name);
            }
    }

    public String[] changeNick(){
        String[] result = new String[logList.size()];

        for(int i=0; i < logList.size(); i++){

            String log = logList.get(i);

            // 님 위치
            int j = log.indexOf("님");

            String id = log.substring(0,j);
            String name = nickMap.get(id);

            // uid -> name으로
            result[i] = log.replaceAll(id,name);

        }

        return result;
    }
}

```
