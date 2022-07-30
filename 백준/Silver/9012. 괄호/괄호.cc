#include <iostream>
#include <stack>
using namespace std;

void solution(void)
{
	stack<char> stk;
	string str;
	cin >> str;
	int n = str.size();
	for (int i = 0; i < n; i++) {
		if (str[i] == '(')
			stk.push('(');
		else {
			if (stk.empty()) {
				cout << "NO\n";
				return;
			}
				
			else
				stk.pop();
		}
	}
	if (stk.empty())
		cout << "YES\n";
	else
		cout << "NO\n";
}

int main(void)
{
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	int T;
	cin >> T;

	for (int i = 0; i < T; i++)
		solution();

	return 0;
}