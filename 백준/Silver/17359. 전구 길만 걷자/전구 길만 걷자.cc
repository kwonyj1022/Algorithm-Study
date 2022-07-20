#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
	int N;
	scanf("%d", &N);
	string* bulb = new string[N];
	int* each = new int[N];

	for (int i = 0; i < N; i++)
		cin >> bulb[i];

	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < bulb[i].size() - 1; j++)
			if (bulb[i].at(j) != bulb[i].at(j + 1))
				cnt++;
	}

	sort(bulb, bulb + N);
	
	int tmp = cnt;
	int min = cnt + N - 1;
	do {
		cnt = tmp;
		for (int i = 0; i < N - 1; i++) {
			if (bulb[i].back() != bulb[i + 1].front())
				cnt++;
		}

		if (cnt < min)
			min = cnt;
	} while (next_permutation(bulb, bulb+N));

	printf("%d", min);

	return 0;
}