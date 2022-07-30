#include <iostream>
#include <queue>
using namespace std;

int main(void)
{
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	int N;
	cin >> N;

	queue<int> q;
	string str;

	for (int i = 0; i < N; i++) {
		cin >> str;
		if (str == "push") {
			int k;
			cin >> k;
			q.push(k);
		}

		else if (str == "pop") {
			if (q.empty())
				cout << "-1\n";
			else {
				cout << q.front() << "\n";
				q.pop();
			}
		}

		else if (str == "size")
			cout << q.size() << "\n";

		else if (str == "empty") {
			if (q.empty())
				cout << "1\n";
			else
				cout << "0\n";
		}

		else if (str == "front") {
			if (q.empty())
				cout << "-1\n";
			else
				cout << q.front() << "\n";
		}

		else if (str == "back") {
			if (q.empty())
				cout << "-1\n";
			else
				cout << q.back() << "\n";
		}
	}

	return 0;
}