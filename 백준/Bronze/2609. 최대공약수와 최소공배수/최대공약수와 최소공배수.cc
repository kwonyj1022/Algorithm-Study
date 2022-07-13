#include <stdio.h>

int main()
{
	int n1, n2;
	scanf("%d %d", &n1, &n2);

	int gcd = 1;
	for (int i = 2; i <= (n1 > n2 ? n2 : n1); i++) {
		while ((n1 % i == 0) && (n2 % i == 0)) {
			gcd *= i;
			n1 = n1 / i;
			n2 = n2 / i;
		}
	}

	int lcm = gcd * n1 * n2;

	printf("%d\n%d", gcd, lcm);

	return 0;
}