#include <iostream>
#include <algorithm>
using namespace std;
struct Data {
	int x, y;
};

bool compare(Data a, Data b)
{
	if (a.x < b.x)
		return true;
	else if (a.x == b.x) {
		if (a.y < b.y)
			return true;
	}
	return false;
}

int main()
{
	int N;
	cin >> N;

	Data* arr = new Data[N];
	for (int i = 0; i < N; i++) {
		scanf("%d %d", &arr[i].x, &arr[i].y);
	}

	sort(arr, arr + N, compare);

	for (int i = 0; i < N; i++)
		printf("%d %d\n", arr[i].x, arr[i].y);

	return 0;
}