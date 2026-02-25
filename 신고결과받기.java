package 프로그래머스;

import java.util.*;

public class 신고결과받기 {
    public static void main(String[] args) {
        sin_Solution s = new sin_Solution();

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {
                "muzi frodo", "apeach frodo", "frodo neo",
                "muzi neo", "apeach muzi"
        };
        int k = 2;

        int[] result = s.solution(id_list, report, k);

        for (int v : result) {
            System.out.print(v + " ");
        }
        // expected: 2 1 1 0
    }
}

class sin_Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        //중복제거
        Set<String> set = new HashSet<>(Arrays.asList(report));

        List<String> list = new ArrayList<>();

        //신고당한 사람의 리스트
        for (String s : set) {
            String[] split = s.split(" ");
            list.add(split[1]);
        }

        Map<String, Integer> map = new HashMap<>();


        //신고 누적 횟수 구하기
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        //k 이상인 정지 대상 구하기
        Set<String> banned = new HashSet<>();

        for(String key : map.keySet()){
            if(map.get(key) >= k){
                banned.add(key);
            }
        }

        // 메일 받을 횟수
        Map<String, Integer> resultMap = new HashMap<>();

        for(String r : set){
            String[] split = r.split(" ");
            String from = split[0];
            String to = split[1];

            if(banned.contains(to)){
                resultMap.put(from, resultMap.getOrDefault(from, 0) + 1);
            }
        }

        // answer 만들기
        int[] answer = new int[id_list.length];

        for(int i = 0; i < id_list.length; i++){
            String user = id_list[i];
            answer[i] = resultMap.getOrDefault(user, 0);
        }


        return answer;
    }
}
