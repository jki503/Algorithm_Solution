# 804. Unique Morse Code Words

- [문제 링크](https://leetcode.com/problems/unique-morse-code-words/)

```java
import java.util.*;

class Solution {

    private String[] morses = new String[26];

    public int uniqueMorseRepresentations(String[] words) {
        setMorses();
        Set<String> set = new HashSet<>();

        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()){
                sb.append(morses[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    private void setMorses(){
        morses[0] = ".-";
        morses[1] = "-...";
        morses[2] = "-.-.";
        morses[3] = "-..";
        morses[4] = ".";
        morses[5] = "..-.";
        morses[6] = "--.";
        morses[7] = "....";
        morses[8] = "..";
        morses[9] = ".---";
        morses[10] = "-.-";
        morses[11] = ".-..";
        morses[12] = "--";
        morses[13] = "-.";
        morses[14] = "---";
        morses[15] = ".--.";
        morses[16] = "--.-";
        morses[17] = ".-.";
        morses[18] = "...";
        morses[19] = "-";
        morses[20] = "..-";
        morses[21] = "...-";
        morses[22] = ".--";
        morses[23] = "-..-";
        morses[24] = "-.--";
        morses[25] = "--..";
    }
}
```
