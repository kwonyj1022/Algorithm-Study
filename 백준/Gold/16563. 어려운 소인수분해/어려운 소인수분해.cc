#include <stdio.h>
int main(void)
{
	int N;
	scanf("%d", &N);
	int* k = new int[N];
	for (int i = 0; i < N; i++)
		scanf("%d", &k[i]);

	const int n = 5000000;
	int min_prime[n + 1] = { 0 };
	for (int i = 2; i <= n; i++)
		for (int j = i; j <= n; j += i)
			if (min_prime[j] == 0)
				min_prime[j] = i;

	for (int i = 0; i < N; i++) {
		int num = k[i];
		while (num > 1) {
			printf("%d ", min_prime[num]);
			num /= min_prime[num];
		}
		printf("\n");
	}
	return 0;
}