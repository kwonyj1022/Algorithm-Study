#include <iostream>
using namespace std;

int main(void) {
	int N;
	scanf("%d", &N);
	int* arr = new int[N+1];

	arr[0] = 0;
	arr[1] = 0;
	for (int i = 2; i <= N; i++) {
		arr[i] = arr[i - 1] + 1;
		if (i % 2 == 0)
			arr[i] = min(arr[i], arr[i / 2] + 1);
		if (i % 3 == 0)
			arr[i] = min(arr[i], arr[i / 3] + 1);
	}

	printf("%d", arr[N]);
	
	return 0;
}