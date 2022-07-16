#include <stdio.h>
#include <algorithm>
using namespace std;

int main()
{
	int N;
	scanf("%d", &N);
	int* arr = new int[N];
	for (int i = 0; i < N; i++)
		scanf("%d", &arr[i]);

	sort(arr, arr + N);
	
	int max = 0;
	do {
		int sum = 0;
		for (int i = 0; i < N-1; i++) {
			if (arr[i] < arr[i + 1])
				sum += arr[i + 1] - arr[i];
			else
				sum += arr[i] - arr[i + 1];
		}
		
		if (sum > max)
			max = sum;
	} while (next_permutation(arr, arr + N));

	printf("%d", max);

	return 0;
}