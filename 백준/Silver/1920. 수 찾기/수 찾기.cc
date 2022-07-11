#include <iostream>
#include <algorithm>
using namespace std;

int isIn(int* arr, int len, int x)
{
	int start = 0, end = len - 1, mid;
	while (start <= end) {
		mid = (start + end) / 2;
		if (x < arr[mid])
			end = mid - 1;
		else if (x > arr[mid])
			start = mid + 1;
		else
			return 1;
	}
	return 0;
}

int main()
{
	int N;
	scanf("%d", &N);
	int* arrN = new int[N];
	for (int i = 0; i < N; i++)
		scanf("%d", &arrN[i]);

	int M;
	scanf("%d", &M);
	int* arrM = new int[M];
	for (int i = 0; i < M; i++)
		scanf("%d", &arrM[i]);

	sort(arrN, arrN + N);

	for (int i = 0; i < M; i++)
		printf("%d\n", isIn(arrN, N, arrM[i]));

	return 0;
}