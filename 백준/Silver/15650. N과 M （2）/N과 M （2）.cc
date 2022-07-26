#include <iostream>
#include <algorithm>
using namespace std;

void f(int*result, int* arr, int N, int M, int k, int index)
{

	if (k == M) {
		for (int i = 0; i < M; i++)
			printf("%d ", result[i]);
		printf("\n");
		return;
	}

	for (int i = index; i < N; i++) {
		result[k] = arr[i];
		index = i+1;
		f(result, arr, N, M, k+1, index);
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

	f(result, arr, N, M, 0, 0);

	return 0;
}