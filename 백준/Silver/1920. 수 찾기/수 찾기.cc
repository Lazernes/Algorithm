#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;
	vector<int>A(N, 0);
	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}
	sort(A.begin(), A.end());

	int M;
	cin >> M;
	vector<int>B(M, 0);
	for (int i = 0; i < M; i++) {
		cin >> B[i];
	}
	vector<int>result(M, 0);

	for (int i = 0; i < M; i++) {
		int tmp = B[i];
		bool exe = binary_search(A.begin(), A.end(), tmp);

		if (exe == true) {
			result[i] = 1;
		}
	}

	for (int i = 0; i < M; i++) {
		cout << result[i] << "\n";
	}
}