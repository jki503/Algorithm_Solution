# 프로그래머스 LEVEL 2 2018 2018 KAKAO BLIND RECRUITMENT [3차] 방금그곡

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17683?language=java)

</br>

```java

class Solution {

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxTime = 0;

        m = changeMelody(m);

        for(String musicinfo : musicinfos){

            String[] info = musicinfo.split(",");

            // 재생 시간
            int time = getTime(info[0],info[1]);
            String title = info[2];
            String melody = changeMelody(info[3]);
            int timeMelody = melody.length();

            StringBuilder sb = new StringBuilder();

            if(time <= timeMelody){
                // 재생시간이 더 짤을때
                sb.append(melody.substring(0,time));
            }
            else{
                //재생시간이 더 길면 반복재생
                int cnt = time/timeMelody;
                int surplus = time % timeMelody;

                for(int i=0;i<cnt;i++){
                    sb.append(melody);
                }

                // 잘린 부분 추가
                if(surplus > 0){
                    sb.append(melody.substring(0,surplus));
                }
            }

            // 음악이 일치하면 answer 갱신
            if(sb.toString().contains(m)){
                if(answer.equals("")){
                    // 없을때
                    answer = title;
                    maxTime = time;
                }
                else{
                    if(time > maxTime){
                        answer = title;
                        maxTime = time;
                    }
                }
            }
        }
        answer = answer.equals("") ? "(None)" : answer;

        return answer;
    }

    // 재생 시간 얻기
    public int getTime(String start, String end ){

        String[] s = start.split(":");
        String[] e = end.split(":");

        return (Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]))
            - ( Integer.parseInt(s[0]) *60 + Integer.parseInt(s[1]));
    }

    // # 제거
    public String changeMelody(String m){
        // 멜로디 변환
        m = m.replaceAll("C#","c");
        m = m.replaceAll("D#","d");
        m = m.replaceAll("E#","e");
        m = m.replaceAll("F#","f");
        m = m.replaceAll("G#","g");

        return m.replaceAll("A#","a");
    }
}

```
