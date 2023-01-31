#include <iostream>
#include <stack>
using namespace std;

int N, A[1000001], B[1000001];

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	
	cin >> N;
	for (int i = 1; i <= N; i++)
		cin >> A[i];

	stack<int> S;

	for (int i = N; i >= 1; i--) {
		while (!S.empty() && S.top() <= A[i])
			S.pop();

		if (S.empty())
			B[i] = -1;
		else
			B[i] = S.top();

		S.push(A[i]);
	}

	for (int i = 1; i <= N; i++)
		cout << B[i] << " ";

	return 0;
}