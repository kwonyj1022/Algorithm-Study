#include <stdio.h>
long long f(long long A, long long B, long long C)
{
	if (B < 2)
		return A % C;

	long long tmp = f(A % C, B / 2, C);

	if (B % 2 == 0) {
		return (tmp * tmp) % C;
	}
	else
		return (((tmp * tmp) % C) * A) % C;
}

int main()
{
	long long A, B, C;
	scanf("%lld %lld %lld", &A, &B, &C);
	
	printf("%lld", f(A, B, C));

	return 0;
}