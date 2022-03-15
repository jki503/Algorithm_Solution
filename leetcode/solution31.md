# leetcode 36. Valid Sudoku

- [문제 링크](https://leetcode.com/problems/valid-sudoku/submissions/)

</br>

```java

import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character> set;

        // col
        for(int y=0; y < 9; y++){
            set = new HashSet<>();

            for(int x=0; x<9; x++){
                if(board[y][x] == '.')
                    continue;

                if(!set.add(board[y][x])){
                    return false;
                }

            }
        }

        // row
        for(int x=0; x < 9; x++){
            set = new HashSet<>();


            for(int y=0; y<9; y++){
                if(board[y][x] == '.')
                    continue;
                if(!set.add(board[y][x])){
                    return false;
                }
            }
        }

        // subbox
        for(int y=0; y < 9; y+=3)
            for(int x=0;x<9;x+=3)
                if(!checkSubBox(y,x,board))
                    return false;


        return true;

    }

    private boolean checkSubBox(int i, int j, char[][] board){

        Set<Character> set = new HashSet<>();

        for(int y = i ; y < i+3; y++)
            for(int x = j ; x < j + 3; x++){
                if(board[y][x] == '.')
                    continue;
                if(!set.add(board[y][x]))
                    return false;
            }

        return true;
    }


}

```
