#include <iostream>
using namespace std;

static int N;
void DFS(int, int);
bool isPrime(int);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	DFS(2, 1);
	DFS(3, 1);
	DFS(5, 1);
	DFS(7, 1);
}

void DFS(int a, int b) {
	if (b == N) {
		if (isPrime(a)) {
			cout << a << "\n";
		}
		return;
	}

	for (int i = 1; i < 10; i = i + 2) {
		if (isPrime(a * 10 + i)) {
			DFS(a * 10 + i, b + 1);
		}
	}
}

bool isPrime(int num) {
	for (int i = 2; i < num; i++) {
		if (num % i == 0) {
			return false;
		}
	}
	return true;
}