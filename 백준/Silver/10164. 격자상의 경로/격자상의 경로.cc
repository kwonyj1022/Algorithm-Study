#include <stdio.h>

int answer(int w, int h)
{
	if (w == 0 || h == 0)
		return 1;

	long long p = 1;
	for (int i = w + h; i > w; i--)
		p = p * i;
	for (int i = h; i > 1; i--)
		p = p / i;

	return p;
}

int main(void)
{
	int N, M, K;
	scanf("%d %d %d", &N, &M, &K);

	if (K == 0) {
		int h = N - 1;
		int w = M - 1;
		printf("%lld", answer(w, h));
	}
	else {
		int h[2] = { 0 };
		int w[2] = { 0 };
		h[0] = (K - 1) / M;
		h[1] = N - h[0] - 1;
		while (true) {
			if (K >= 1 && K <= M)
				break;
			K -= M;
		}
		w[0] = K - 1;
		w[1] = M - w[0] - 1;

		printf("%lld", answer(w[0], h[0]) * answer(w[1], h[1]));
	}

	return 0;
}