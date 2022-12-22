#include <stdio.h>
int cnt, N, r, c;
void f(int n, int sr, int sc) {
	if (n == 0) {
		return;
	}
	if ((sr <= r) && (r < sr + n / 2) && (sc <= c) && (c < sc + n / 2)) {
		f(n / 2, sr, sc);
	}
	else if ((sr <= r) && (r < sr + n / 2) && (sc + n / 2 <= c) && (c < sc + n)) {
		cnt += ((n / 2) * (n / 2));
		f(n / 2, sr, sc + n / 2);
	}
	else if ((sr + n / 2 <= r) && (r < sr + n) && (sc <= c) && (c < sc + n / 2)) {
		cnt += ((n / 2) * (n / 2)) * 2;
		f(n / 2, sr + n / 2, sc);
	}
	else if ((sr + n / 2 <= r) && (r < sr + n) && (sc + n / 2 <= c) && (c < sc + n)) {
		cnt += ((n / 2) * (n / 2)) * 3;
		f(n / 2, sr + n / 2, sc + n / 2);
	}
}

int main() {
	scanf("%d %d %d", &N, &r, &c);

	f(1 << N, 0, 0);
	printf("%d", cnt);
}