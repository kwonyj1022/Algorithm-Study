#include <stdio.h>
#include <algorithm>
using namespace std;

int min(int n1, int n2) {
	return n1 < n2 ? n1 : n2;
}

int main(void) {
	int n, k;
	scanf("%d %d", &n, &k);

	int* coin = new int[n];
	for (int i = 0; i < n; i++)
		scanf("%d", &coin[i]);

	sort(coin, coin + n);
	for (int i = 0; i < n - 1; i++)
		if (coin[i] == coin[i + 1])
			coin[i] = 0;

	int* cnt = new int[k + 1];
	for (int i = 0; i <= k; i++)
		cnt[i] = 10001;
	for (int i = 0; i < n; i++)
		if (coin[i] > 0)
			cnt[coin[i]] = 1;

	for (int i = 1; i <= k; i++)
		for (int j = 0; j < n; j++)
			if (coin[j] > 0)
				if (i - coin[j] > 0)
					cnt[i] = min(cnt[i], cnt[i - coin[j]] + 1);

	printf("%d", cnt[k] < 10001 ? cnt[k] : -1);

	delete[] coin;
	delete[] cnt;

	return 0;
}