#include <stdio.h>
int N;
char D[2187][2187];

void f(int sr, int sc, int n, int tf) {
	if (n == 1) {
		if (tf == 1)
			D[sr][sc] = '*';
		else if (tf == 0)
			D[sr][sc] = ' ';
		return;
	}

	if (tf == 1) {
		n = n / 3;
		f(sr, sc, n, 1);
		f(sr, sc + n, n, 1);
		f(sr, sc + 2 * n, n, 1);
		f(sr + n, sc, n, 1);
		f(sr + n, sc + n, n, 0);
		f(sr + n, sc + 2 * n, n, 1);
		f(sr + 2 * n, sc, n, 1);
		f(sr + 2 * n, sc + n, n, 1);
		f(sr + 2 * n, sc + 2 * n, n, 1);
	}
	else if (tf == 0) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				D[sr + i][sc + j] = ' ';
			}
		}
	}
}

int main() {
	scanf("%d", &N);
	f(0, 0, N, 1);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			printf("%c", D[i][j]);
		}
		printf("\n");
	}
}