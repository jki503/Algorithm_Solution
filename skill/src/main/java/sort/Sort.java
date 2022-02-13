package sort;

import java.util.Arrays;
import java.util.Comparator;


public class Sort{

    public static void main(String[] args) {
        // 1번 int 배열을 내림차순으로 정렬
        int[] descArr = descArraysSort(new int[]{4,5,3,3,1});
        print(descArr);

        String[] strArr ={"ab001","ac002","ad003","cc013","cc025","cc12"};
        // 2번 String 배열을 prefix 기준으로, 같으면 두 번째 기준으로
        String[] strArr1 = stringSort1(strArr);
        print(strArr1);

        // 3번 String 배열을 뒤에 숫자 기준으로 오름차순 정렬 001은 1과 같다.
        String[] strArr2 = stringSort2(strArr);
        print(strArr2);
    }

    public static int[] descArraysSort(int intArr[]){
//      int[] -> Integer[]

        Integer[] integerArr = Arrays.stream(intArr).boxed().toArray(Integer[]::new);

//      Arrays.sort(integerArr,Collections.reverseOrder());

        Arrays.sort(integerArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                /*
                o1 - o2
                -> 음수 : o1이 더 작다 0:
                -> 0 : 같다
                -> 양수 : o1이 더 크다
                 */

                return o1 - o2 <= 0 ? 1 : -1;
            }
        });

        // Integer[] -> int[]
        return Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();
    }

    public static String[] stringSort1(String[] strArr){

        Arrays.sort(strArr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                int prefix = s1.charAt(0) - s2.charAt(0);
                // 같으면
                if (prefix == 0) {
                    return s2.charAt(1) - s2.charAt(1);
                }
                return prefix;
            }
        });

        return strArr;
    }

    public static String[] stringSort2(String[] strArr){
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int num1 = findIdentifier(s1);
                int num2 = findIdentifier(s2);

                return num1 - num2;
            }
        });

        return strArr;
    }

    public static int findIdentifier(String s){
        StringBuilder num = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr >='0' && curr <='9')
                num.append(curr);
        }

        return Integer.parseInt(num.toString());
    }

    public static void print(int[]arr){
        for (int num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void print(String[] arr){
        for(String str: arr){
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
