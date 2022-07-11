#include <stdio.h>
int main()
{
	int N, S;
	scanf("%d %d", &N, &S);
	int* arr = new int[N];
	for (int i = 0; i < N; i++)
		scanf("%d", &arr[i]);

	int cnt = 0;
	for (int bit = 1; bit < (1 << N); bit++) {
		int sum = 0;
		for (int i = 0; i < N; i++)
			if (bit & (1 << i))
				sum += arr[i];
		if (sum == S)
			cnt++;
	}

	printf("%d", cnt);

	return 0;
}