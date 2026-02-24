package 프로그래머스;

import java.util.*;

public class 완주하지못한선수 {

    public static void main(String[] args) {

        participant_Solution s = new participant_Solution();

//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};

        String[] participant = {"leo", "leo", "kiki"};
        String[] completion = {"leo", "kiki"};

        String result = s.solution(participant, completion);

        System.out.println("완주하지 못한 선수: " + result);
    }
}

class participant_Solution {
    public String solution(String[] participant, String[] completion) {

        //해시맵 사용
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i = 0; i < completion.length; i++) {
            String key = completion[i];
            int value = map2.getOrDefault(key, 0);
            value = value + 1;
            map2.put(key, value);
        }


        for (int i = 0; i < participant.length; i++) {
            String key = participant[i];
            int value = map.getOrDefault(key, 0);
            value = value + 1;
            map.put(key, value);
            if (map2.containsKey(key)) {
                int value2 = map2.getOrDefault(key, 0);
                if(value2 > 0) {
                    value2 = value2 - 1;
                    value = value - 1;
                }
                map.put(key, value);
                map2.put(key, value2);
            }
        }

//        for(int i =0; i<participant.length; i++){
//            System.out.println(map.get(participant[i]));
//        }


        String answer = "";

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
            }
        }
        return answer;

    }
}