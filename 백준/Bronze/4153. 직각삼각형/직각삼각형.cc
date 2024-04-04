#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int a, b, c;
	while(1) {
		cin >> a >> b >> c;

		if (a == 0 && b == 0 && c == 0) {
			break;
		}

		bool result = false;

		if (a >= b && a >= c) {
			if (a * a == b * b + c * c) {
				result = true;
			}
		}
		else if (b >= a && b >= c) {
			if (b * b == a * a + c * c) {
				result = true;
			}

		}
		else if (c >= a && c >= b) {
			if (c * c == b * b + a * a) {
				result = true;
			}
		}

		if (result) {
			cout << "right\n";
		}
		else {
			cout << "wrong\n";
		}
	}
}