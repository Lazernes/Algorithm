#include <iostream>
#include <vector>
using namespace std;


vector<vector<int>> A;
vector<bool> V;
void DFS(int v);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	cin >> N >> M;
	A.resize(N + 1);
	V = vector<bool>(N + 1, false);

	for (int i = 0; i < M; i++) {
		int s, e;
		cin >> s >> e;
		A[s].push_back(e);
		A[e].push_back(s);
	}

	int count = 0;

	for (int i = 1; i < N + 1; i++) {
		if (V[i] == false) {
			count++;
			DFS(i);
		}
	}
	cout << count;
}

void DFS(int v) {
	if (V[v]) {
		return;
	}

	V[v] = true;

	for (int i: A[v]) {
		if (V[i] == false) {
			DFS(i);
		}
	}
}