#include <iostream>

int main() {
	int N, B, C;
	scanf("%d", &N);
	int* A = new int[N];
	for (int i = 0; i < N; i++)
		scanf("%d", &A[i]);
	scanf("%d", &B);
	scanf("%d", &C);

	long long answer = 0;
	for (int i = 0; i < N; i++) {
		if (A[i] <= B)
			answer += 1;
		else {
			if ((A[i] - B) % C == 0)
				answer += 1 + (A[i] - B) / C;
			else
				answer += 1 + (A[i] - B) / C + 1;
		}
	}

	printf("%lld\n", answer);

	delete []A;

	return 0;
}