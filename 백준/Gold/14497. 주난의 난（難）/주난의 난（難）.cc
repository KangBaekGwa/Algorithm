#include <bits/stdc++.h>

using namespace std;

char Map[304][304];
int Visited[304][304];
int junan_x, junan_y, target_x, target_y, N, M, cnt;
int dx[4] = {0, 1, 0, -1};
int dy[4] = {-1, 0, 1, 0};
queue<pair<int, int>> q;

void bfs(int y, int x)
{
    q.push({junan_y, junan_x});
    Visited[junan_y][junan_x] = 1;

    while(Map[target_y][target_x] != '0')
    {
        queue<pair<int, int>> temp;
        cnt++;
        while(q.size())
        {
            tie(y, x) = q.front(); q.pop();
            for(int i=0; i<4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(Visited[ny][nx]) continue;

                Visited[ny][nx] = cnt;
                if(Map[ny][nx] != '0')
                {
                    temp.push({ny, nx});
                    Map[ny][nx] = '0';
                }
                else
                {
                    q.push({ny, nx});
                }
            }
        }
        q = temp;
    }
}

int main()
{
    cin >> N >> M;
    cin >> junan_y >> junan_x >> target_y >> target_x;
    junan_x = junan_x-1;
    junan_y = junan_y-1;
    target_x = target_x-1;
    target_y = target_y-1;

    for(int i=0; i<N; i++)
    {
        for(int ii=0; ii<M; ii++)
        {
            cin >> Map[i][ii];
        }
    }

    bfs(junan_y, junan_x);
    cout << Visited[target_y][target_x] << '\n';
}