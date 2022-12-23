#include <stdio.h>
#include <algorithm>
using namespace std;
int N, P;
int M[10], C[10], D[10][10];

void f() {
	do {
		int c[10] = { 0 };
		for (int i = 0; i < N; i++) {
			c[i] = C[i];
		}

		int tmp = c[M[0]];
		for (int i = 1; i < N; i++) {
			for (int j = i; j < N; j++) {
				c[M[j]] -= D[M[i - 1]][M[j]];
			}
			if (c[M[i]] < 1)
				c[M[i]] = 1;
			tmp += c[M[i]];
		}

		if (P > tmp) {
			P = tmp;
		}
	} while (next_permutation(M, M + N));
}

int main() {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &C[i]);
	}
	for (int i = 0; i < N; i++) {
		int p;
		scanf("%d", &p);
		for (int j = 0; j < p; j++) {
			int a;
			scanf("%d", &a);
			scanf("%d", &D[i][a - 1]);
		}
	}

	for (int i = 0; i < 10; i++) {
		M[i] = i;
		P += C[i];
	}
	
	f();

	printf("%d", P);
}