#include <stdio.h>

int main()
{
	int n;
	scanf("%d", &n);
	int* fibo = new int[n + 1];
	fibo[0] = 0;
	fibo[1] = 1;
	for (int i = 2; i <= n; i++)
		fibo[i] = fibo[i - 2] + fibo[i - 1];

	printf("%d", fibo[n]);
	return 0;
}