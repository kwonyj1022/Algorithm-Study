#include <iostream>
using namespace std;
int main()
{
	long long N, P;
	cin >> N >> P;
	long long Nfac = 1;
	for (long long i = 1; i <= N; i++) {
		Nfac *= i;
		Nfac %= P;
	}

	cout << Nfac % P << endl;

	return 0;
}