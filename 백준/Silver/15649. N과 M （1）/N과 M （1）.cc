#include <iostream>
#include <algorithm>
using namespace std;

void f(int*result, int* arr, int N, int M, int k)
{

	if (k == M) {
		for (int i = 0; i < M; i++)
			printf("%d ", result[i]);
		printf("\n");
		return;
	}

	for (int j = 0; j < N; j++) {
		int same = 0;
		for (int a = 0; a < k; a++) {
			if (result[a] == arr[j]) {
				same = 1;
				break;
			}
		}

		if (same == 0) {
			result[k] = arr[j];
			f(result, arr, N, M, k+1);
		}
	}

	return;
}
int main()
{
	int N, M;
	scanf("%d %d", &N, &M);
	int* arr = new int[N];
	int* result = new int[M];
	for (int i = 0; i < N; i++)
		arr[i] = i + 1;

	int k = 0;
	f(result, arr, N, M, k);

	return 0;
}