#include <stdio.h>
#include <math.h>

int main()
{
	long long n;
	scanf("%lld", &n);

	long long result = (long long)sqrt(n);
	if (result * result < n)
		result++;

	printf("%lld\n", result);

	return 0;
}