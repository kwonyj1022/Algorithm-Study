#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void Solve(void) {
	int N;
	cin >> N;

	priority_queue<int, vector<int>, less<>> max_heap;
	priority_queue<int, vector<int>, greater<>> min_heap;

	int root;
	cin >> root;

	cout << (N + 1) / 2 << "\n" << root << " ";
	for (int i = 0; i < N / 2; i++) {
		int a, b;
		cin >> a >> b;
		if (a > b)
			swap(a, b);
		if (a <= root && root <= b) {
			max_heap.push(a);
			min_heap.push(b);
		}
		else if (b <= root) {
			max_heap.push(a);
			max_heap.push(b);
			min_heap.push(root);
			root = max_heap.top();
			max_heap.pop();
		}
		else {
			min_heap.push(a);
			min_heap.push(b);
			max_heap.push(root);
			root = min_heap.top();
			min_heap.pop();
		}

		cout << root << " ";
	}
	cout << "\n";
}

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

	int T;
	cin >> T;

	for (int i = 0; i < T; i++)
		Solve();

	return 0;
}