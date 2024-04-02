#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

bool comp(pair<int, string>a, pair<int, string>b) {
	if (a.first != b.first) {
		return a.first < b.first;
	}
	else if (a.first == b.first) {
		return a.second < b.second;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	typedef pair<int, string> Dic;
	vector<Dic>A(N);

	for (int i = 0; i < N; i++) {
		cin >> A[i].second;
		A[i].first = A[i].second.size();
	}

	sort(A.begin(), A.end(), comp);

	cout << A[0].second << "\n";
	for (int i = 1; i < N; i++) {
		if (A[i] != A[i - 1]) {
			cout << A[i].second << "\n";
		}
	}

}