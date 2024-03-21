#include <iostream>
using namespace std;
int color[129][129];
int white, blue;

void solution(int N, int x, int y)
{
	int cnt = 0;

	for (int i = x; i < x + N; i++)
		for (int j = y; j < y + N; j++)
			if (color[i][j] == 0)
				cnt++;

	if (cnt == N * N)
		white++;
	else if (cnt == 0)
		blue++;
	else {
		solution(N / 2, x, y);
		solution(N / 2, x + N / 2, y);
		solution(N / 2, x, y + N / 2);
		solution(N / 2, x + N / 2, y + N / 2);
	}

	return;
}

int main(void)
{
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	int N;
	cin >> N;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			cin >> color[i][j];

	solution(N, 0, 0);
	cout << white << "\n" << blue;

	return 0;
}