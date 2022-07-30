#include <iostream>
#include <stack>
using namespace std;

int main(void)
{
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	int N;
	cin >> N;

	stack<int> stk;
	string str;

	for (int i = 0; i < N; i++) {
		cin >> str;
		if (str == "push") {
			int k;
			cin >> k;
			stk.push(k);
		}

		else if (str == "pop") {
			if (stk.empty())
				cout << "-1\n";
			else {
				cout << stk.top() << "\n";
				stk.pop();
			}
		}

		else if (str == "size")
			cout << stk.size() << "\n";

		else if (str == "empty") {
			if (stk.empty())
				cout << "1\n";
			else
				cout << "0\n";
		}

		else if (str == "top") {
			if (stk.empty())
				cout << "-1\n";
			else
				cout << stk.top() << "\n";
		}
	}

	return 0;
}