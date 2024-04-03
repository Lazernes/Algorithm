#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string N;
	cin >> N;

	int tmp = N.size();

	int F;
	cin >> F;

	int result;

	for (int i = 0; i < 100; i++) {
		result = i;

		if (i < 10) {
			N[tmp - 2] = '0';
			N[tmp - 1] = i + '0';
		}
		else {
			int t1 = i % 10;
			int t2 = i / 10;
			N[tmp - 2] = t2 + '0';
			N[tmp - 1] = t1 + '0';
		}

		int temp = stoi(N);

		if (temp % F == 0) {
			break;
		}
	}

	if (result < 10) {
		cout << "0" << result;
	}
	else {
		cout << result;
	}
}