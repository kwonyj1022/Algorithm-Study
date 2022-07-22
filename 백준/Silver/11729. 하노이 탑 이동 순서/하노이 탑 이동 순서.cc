#include <stdio.h>

void hanoi(int N, int from, int to, int mid) {
	if (N == 1)
		printf("%d %d\n", from, to);

	else {
		hanoi(N - 1, from, mid, to);
		hanoi(1, from, to, mid);
		hanoi(N - 1, mid, to, from);
	}
}

int count(int N) {
	if (N == 1)
		return 1;
	else
		return 2 * count(N - 1) + 1;
}

int main()
{
	int N;
	scanf("%d", &N);
	printf("%d\n", count(N));
	hanoi(N, 1, 3, 2);

	return 0;
}