#include <stdio.h>
int N;
char arr[65][65];
void f(int n, int sr, int sc) {
	for (int i = sr; i < sr + n - 1; i++) {
		for (int j = sc; j < sc + n - 1; j++) {
			if (arr[i][j] != arr[i][j + 1] || arr[i][j] != arr[i + 1][j] || arr[i][j] != arr[i + 1][j + 1]) {
				printf("(");
				f(n / 2, sr, sc);
				f(n / 2, sr, sc + n / 2);
				f(n / 2, sr + n / 2, sc);
				f(n / 2, sr + n / 2, sc + n / 2);
				printf(")");
				return;
			}
		}
	}
	if (arr[sr][sc] == '0') {
		printf("0");
	}
	else if (arr[sr][sc] == '1') {
		printf("1");
	}
}

int main() {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%s", arr[i]);
	}
	f(N, 0, 0);
}