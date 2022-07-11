#include <stdio.h>

int main()
{
	int N;
	scanf("%d", &N);
	int* arr = new int[N];
	for (int i = 0; i < N; i++)
		scanf("%d", &arr[i]);
	
	int count = 0;

	for (int i = 0; i < N; i++) {
		if (arr[i] == 1)
			continue;
		else if (arr[i] == 2) {
			count++;
			continue;
		}
		for (int j = 2; j < arr[i]; j++) {
			if (arr[i] % j == 0)
				break;
			
			if (j == arr[i] - 1)
				count++;
		}
	}

	printf("%d", count);

	return 0;
}