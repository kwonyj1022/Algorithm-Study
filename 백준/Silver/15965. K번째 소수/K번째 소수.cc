#include <stdio.h>
#include <vector>
using namespace std;
int main()
{
	int K;
	scanf("%d", &K);
	int n = 7368787;
	vector<int> isPrime(n + 1, 1);
	vector<int> primes;

	for (int i = 2; i <= n; i++) {
		if (isPrime[i] == 1) {
			primes.push_back(i);
			for (int j = i + i; j <= n; j += i)
				isPrime[j] = 0;
		}
	}
	
	printf("%d", primes[K-1]);
	return 0;
}