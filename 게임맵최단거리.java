package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        ge_Solution sol = new ge_Solution();

        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        System.out.println(sol.solution(maps)); // 11
    }
}

class ge_Solution {
    public int solution(int[][] maps) {

        // 세로 길이
        int n = maps.length;

        // 가로 길이
        int m = maps[0].length;

        // 각 칸까지 도달하는 데 걸린 거리 저장
        // 0으로 초기화
        int[][] dist = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        // 상하좌우 이동 (아래, 위, 오른쪽, 왼쪽)
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        // 1. 시작점 처리
        dist[0][0] = 1;

        // 큐에 시작점 넣기 → 여기서부터 탐색 시작
        q.offer(new int[]{0, 0});

        // 2. BFS 시작
        // 큐가 빌 때까지 계속 반복
        while (!q.isEmpty()) {

            // 현재 위치 하나 꺼냄
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            // 3. 현재 위치에서 4방향 확인
            for (int i = 0; i < 4; i++) {

                // 다음 위치 계산
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 4. 범위 체크 (맵 밖이면 패스)
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 5. 벽이면 못 감
                if (maps[nx][ny] == 0) {
                    continue;
                }

                // 6. 이미 방문한 칸이면 패스
                if (dist[nx][ny] != 0) {
                    continue;
                }

                // 7. 거리 저장
                dist[nx][ny] = dist[x][y] + 1; //현재칸 +1

                // 8. 큐에 넣기
                // 나중에 이 칸 기준으로 또 탐색해야 함
                q.offer(new int[]{nx, ny});
            }
        }


        // 도착 못 했으면 -1
        if (dist[n - 1][m - 1] == 0) {
            return -1;
        }

        return dist[n - 1][m - 1];
    }
}