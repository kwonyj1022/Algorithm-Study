#include <stdio.h>
int main(void) {
	int n, k;
	scanf("%d %d", &n, &k);
	int* coin = new int[n];
	for (int i = 0; i < n; i++)
		scanf("%d", &coin[i]);
    
	int cnt[10001] = { 0 };
	cnt[0] = 1;
    
	for (int i = 0; i < n; i++)
		for (int j = 1; j <= k; j++)
			if (j - coin[i] >= 0)
				cnt[j] += cnt[j - coin[i]];

	printf("%d", cnt[k]);
	delete[] coin;

	return 0;
}