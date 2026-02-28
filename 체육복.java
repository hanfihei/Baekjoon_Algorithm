package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 체육복 {
    public static void main(String[] args) {
        physical_Solution s = new physical_Solution();

        // ✅ 실패 포인트: 1번 학생이 여벌(2)일 때, 네 대여 로직이 "왼쪽(i=0 -> key=0)"으로 먼저 줘버려서
        // map에 0번 키가 생기고, count에서 그 0번도 같이 세어버림 -> n보다 크게 나오거나, 실제 부족을 가려버림

        // 1) lost가 없는데 reserve에 1번이 있는 경우: 원래 전원 수업 가능 = n
        System.out.println(s.solution(3, new int[]{}, new int[]{1})); // 기대값: 3 (네 코드는 보통 4 나옴)

        // 2) lost가 없고 reserve에 1번 포함: n보다 크게 나오는 케이스
        System.out.println(s.solution(5, new int[]{}, new int[]{1, 3})); // 기대값: 5 (네 코드는 보통 6 나옴)

        // 3) 1번이 여벌이지만, 잃어버린 학생이 멀리 있어서 못 빌려줌: 전원은 불가
        System.out.println(s.solution(5, new int[]{4}, new int[]{1})); // 기대값: 4 (네 코드는 보통 5 나옴)

        // 4) 위 케이스 변형 (멀리 lost가 더 많아져도 동일하게 깨짐)
        System.out.println(s.solution(5, new int[]{4, 5}, new int[]{1})); // 기대값: 3 (네 코드는 보통 4 나옴)
    }
}

class physical_Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //n은 전체학생 수
        //lost는 읽어버린 학생 번호
        //reserve는 여벌의 옷이 있는 학생
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 99);

        //가지고 있는 체육복 개수 구하기
        for(int i = 0; i<n; i++){
            map.put(i+1, 1);

            for(int j = 0; j<lost.length; j++){
                if(i+1 == lost[j]){
                    int value1 = map.getOrDefault(i+1, 0);
                    map.put(i+1, value1 - 1);
                }
            }
            for(int x = 0; x<reserve.length; x++){
                if(i+1 == reserve[x]){
                    int value2 = map.getOrDefault(i+1, 0);
                    map.put(i+1, value2 + 1);
                }
            }
        }

        for(int i = 0; i<n; i++){
            if(map.getOrDefault(i+1, 0)==2){
                if(map.getOrDefault(i, 0)==0){
                    map.put(i, 1);
                    map.put(i+1, 1);
                }
                if(i+1 != n && map.getOrDefault(i+2, 0)==0 && map.getOrDefault(i+1, 0)==2){
                    map.put(i+2, 1);
                    map.put(i+1, 1);
                }
            }
        }

        int count = 0;
        for(Integer x : map.keySet()){
            if(map.get(x)==1 || map.get(x)==2){
                count += 1;
            }
        }


    //로직 일단 map을 만들어서 키를 학생번호로 하고(1~n까지) 값을 모두 1을 준 후 여분의 옷을 가지고 있는 학생은 추가로 값에 +1을 해주고 lost인 친구는 -1을 해줌
        //그 다음엔 이제 값이 2인 친구들만 체육복을 빌려줄 수 있음
        //그럼 value가 2인 친구들을 모아서 0인 친구들을 줄수 있는데
        //여기서 키값의 +1 -1인 친구들만 빌려 줄 수 있음
        //빌려줫으면 값을 -1해주고 받은 친구들 +1해줘야함
        //마지막으로 값이 1인 친구들의 개수를 세주면됨

        return count;
    }
}