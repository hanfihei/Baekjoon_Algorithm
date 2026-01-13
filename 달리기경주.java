package 프로그래머스;

import java.util.*;

public class 달리기경주 {
    public static void main(String[] args) {

        Run_Solution sol = new Run_Solution();

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] result = sol.solution(players, callings);
        System.out.println(Arrays.toString(result));
    }
}

class Run_Solution {
    public String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            String name = callings[i];
            int rank = map.get(name);

            String name2 = players[rank - 1];

            players[rank - 1] = name;
            players[rank] = name2;

            map.put(name, rank - 1);
            map.put(name2, rank);
        }

        return players;
    }
}
