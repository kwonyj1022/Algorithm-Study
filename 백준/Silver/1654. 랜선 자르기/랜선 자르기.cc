#include <iostream>
using namespace std;

unsigned int arr[10000];
unsigned int answer;

unsigned int maxNum(unsigned int n1, unsigned int n2)
{
	if (n1 > n2)
		return n1;
	else
		return n2;
}

int main(void)
{
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	unsigned int K, N;
	cin >> K >> N;
	for (int i = 0; i < K; i++)
		cin >> arr[i];

	unsigned int max = arr[0];
	for (int i = 1; i < K; i++)
		max = maxNum(max, arr[i]);

	unsigned int l = 1, r = max;
	while (l <= r) {
		unsigned int m = (l + r) / 2;

		unsigned int sum = 0;
		for (int i = 0; i < K; i++)
			sum += arr[i] / m;

		if (sum >= N) {
			answer = maxNum(answer, m);
			l = m + 1;
		}
		else
			r = m - 1;
	}
	cout << answer;

	return 0;
}