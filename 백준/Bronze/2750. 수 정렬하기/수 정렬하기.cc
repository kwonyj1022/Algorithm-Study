#include <iostream>
using namespace std;

void sort(int* p, int N)
{
	for (int i = 0; i < N - 1; i++) {
		for (int j = i + 1; j < N; j++) {
			if (p[j] < p[i]) {
				int temp = p[j];
				p[j] = p[i];
				p[i] = temp;
			}
		}
	}

	for (int i = 0; i < N; i++) {
		cout << p[i] << endl;
	}
}

int main(void)
{
	int N;
	cin >> N;
	int* p = new int[N];
	for (int i = 0; i < N; i++)
		cin >> p[i];

	sort(p, N);

	delete[] p;
}