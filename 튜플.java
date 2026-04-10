package 프로그래머스;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        tu_Solution solution = new tu_Solution();

        System.out.println(Arrays.toString(solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))); // [2, 1, 3, 4]
        System.out.println(Arrays.toString(solution.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))); // [2, 1, 3, 4]
        System.out.println(Arrays.toString(solution.solution("{{20,111},{111}}"))); // [111, 20]
        System.out.println(Arrays.toString(solution.solution("{{123}}"))); // [123]
        System.out.println(Arrays.toString(solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))); // [3, 2, 4, 1]
    }
}

class tu_Solution {
    public int[] solution(String s) {

//        "{{4,2,3},{3},{2,3,4,1},{2,3}}"
            //일때 1 2 3 4로 정렬 하고
        //ㅈ일단 순서대러 정렬하고 그 앞에 있던 숫자를 앞으로?if만약에 2번째에
        //그럼 정렬하고 배열을 새로 만들어서 1번 튜플부터 저장시키고,
        //2번 튜플일때 배열에 들어있는 튜플의 값을 제외하고 나머지 1개를 배열에 저장시킴
        // 2중포문 돌면서  if 배열에 없는 숫자가 있다면 배열에 삽입

        //그럼 일단 1~n까지 어떻게 저장할 것인지 생각
        //n을 만들어서 2차원배열 만들고 if
        //String이니까 돌면서 {를 모으고 }만날시에 수를 초기화하고 저장

        int[][] arr = new int[s.length()][s.length()];
        int n = 0;
        char[] now = new char[s.length()];
        boolean ox = false;

        for(int i = 1; i < s.length()-1; i++) {
            char c = s.charAt(i);
            if (c == '{') {
                for (int j = i + 1; j < s.length(); j++) {
                    char c2 = s.charAt(j);
                    if(c2 != ',') {
                        now[n] += c2;
                    }

                    if (c2 == '}') {
                        for (int x = 0; x < n; x++) {
                            arr[n][x] = now[x];
                            now[x] = 0;
                        }
                        n = 0;
                        break;
                    }
                }
            }
        }



        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "] = [ ");
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println("]");
        }

        System.out.println("끝");


        return new int[]{};



    }
}