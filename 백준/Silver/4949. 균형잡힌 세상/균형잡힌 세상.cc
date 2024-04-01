#include <iostream>
#include <stack>
#include <string>
#include <cstring>
using namespace std;

bool Balance(string S) {
	stack<char>st;

	for (int i = 0; i < S.size(); i++) {
		if (S[i] == '(') {
			st.push('(');
		}
		else if (S[i] == '[') {
			st.push('[');
		}
		else if (S[i] == ')') {
			if (st.empty()) {
				return false;
			}
			else if (st.top() != '(') {
				return false;
			}
			else {
				st.pop();
			}
		}
		else if (S[i] == ']') {
			if (st.empty()) {
				return false;
			}
			else if (st.top() != '[') {
				return false;
			}
			else {
				st.pop();
			}
		}
	}

	if (st.empty()) {
		return true;
	}
	else {
		return false;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	while (1) {
		string S;
		getline(cin, S);

		if (S == ".") {
			break;
		}

		if (Balance(S)) {
			cout << "yes\n";
		}
		else {
			cout << "no\n";
		}
	}

}