#include <iostream>
#include <deque>
using namespace std;

int main(void)
{
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	int N;
	cin >> N;

	deque<int> dq;
	string str;

	for (int i = 0; i < N; i++) {
		cin >> str;
		if (str == "push_front") {
			int k;
			cin >> k;
			dq.push_front(k);
		}

		else if (str == "push_back") {
			int k;
			cin >> k;
			dq.push_back(k);
		}

		else if (str == "pop_front") {
			if (dq.empty())
				cout << "-1\n";
			else {
				cout << dq.front() << "\n";
				dq.pop_front();
			}
		}

		else if (str == "pop_back") {
			if (dq.empty())
				cout << "-1\n";
			else {
				cout << dq.back() << "\n";
				dq.pop_back();
			}
		}

		else if (str == "size")
			cout << dq.size() << "\n";

		else if (str == "empty") {
			if (dq.empty())
				cout << "1\n";
			else
				cout << "0\n";
		}

		else if (str == "front") {
			if (dq.empty())
				cout << "-1\n";
			else
				cout << dq.front() << "\n";
		}

		else if (str == "back") {
			if (dq.empty())
				cout << "-1\n";
			else
				cout << dq.back() << "\n";
		}
	}

	return 0;
}