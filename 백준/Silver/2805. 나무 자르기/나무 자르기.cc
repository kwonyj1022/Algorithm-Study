#include <iostream>
using namespace std;

int arr[1000000];
int answer;

int maxNum(int n1, int n2)
{
	if (n1 > n2)
		return n1;
	else
		return n2;
}

int main(void)
{
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	int N, M;
	cin >> N >> M;
	for (int i = 0; i < N; i++)
		cin >> arr[i];

	int max = arr[0];
	for (int i = 1; i < N; i++)
		max = maxNum(max, arr[i]);

	int l = 0, r = max;
	while (l <= r) {
		int m = (l + r) / 2;

		long long sum = 0;
		for (int i = 0; i < N; i++)
			if (arr[i] > m)
				sum += arr[i] - m;

		if (sum >= M) {
			answer = maxNum(answer, m);
			l = m + 1;
		}
		else
			r = m - 1;
	}
	cout << answer;

	return 0;
}