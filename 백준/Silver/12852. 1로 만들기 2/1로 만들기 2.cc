#include <stdio.h>
int min(int n1, int n2) {
	return n1 < n2 ? n1 : n2;
}

int main(void) {
	int N;
	scanf("%d", &N);
	int* arr = new int[N + 1];

	arr[0] = 0;
	arr[1] = 0;
	for (int i = 2; i <= N; i++) {
		arr[i] = arr[i - 1] + 1;
		if (i % 2 == 0)
			arr[i] = min(arr[i], arr[i / 2] + 1);
		if (i % 3 == 0)
			arr[i] = min(arr[i], arr[i / 3] + 1);
	}
	printf("%d\n", arr[N]);

	while (true) {
		printf("%d ", N);

		if (arr[N] == 0)
			break;

		if (arr[N] == arr[N - 1] + 1) {
			N = N - 1;
			continue;
		}
		if ((N % 2 == 0) && (arr[N] == arr[N / 2] + 1)) {
			N = N / 2;
			continue;
		}
		if ((N % 3 == 0) && (arr[N] == arr[N / 3] + 1)) {
			N = N / 3;
			continue;
		}
	}

	delete[] arr;

	return 0;
}