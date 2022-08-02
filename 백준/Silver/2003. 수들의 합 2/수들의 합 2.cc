#include <iostream>
using namespace std;

int A[10000], cnt;

int main(void)
{
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	int N, M;
	cin >> N >> M;
	for (int i = 0; i < N; i++)
		cin >> A[i];

	for (int i = 0; i < N; i++) {
		int sum = 0;
		for (int j = i; j < N; j++) {
			sum += A[j];

			if (sum == M) {
				cnt++;
				break;
			}
			if (sum > M)
				break;
		}
	}
	cout << cnt;

	return 0;
}