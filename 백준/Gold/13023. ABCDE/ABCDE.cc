#include <iostream>
#include <vector>
using namespace std;

vector<vector <int>> G;
bool visit[2000] = { false };
bool arrive;
void DFS(int now, int depth);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	cin >> N >> M;

	arrive = false;
	G.resize(N);

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		G[a].push_back(b);
		G[b].push_back(a);
	}
	
	for (int i = 0; i < N; i++) {
		DFS(i, 1);
		if (arrive) {
			break;
		}
	}

	if (arrive) {
		cout << "1";
	}
	else {
		cout << "0";
	}

}

void DFS(int now, int depth) {
	if (depth == 5 || arrive) {
		arrive = true;
		return;
	}

	visit[now] = true;
	for (int i: G[now]) {
		if (!visit[i]) {
			DFS(i, depth + 1);
		}
	}
	visit[now] = false;
}