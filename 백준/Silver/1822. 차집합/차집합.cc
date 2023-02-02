#include <iostream>
#include <set>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	
	int a, b;
	cin >> a >> b;
	
	set<int> s;
	for (int i = 0; i < a; i++) {
		int t;
		cin >> t;
		s.insert(t);
	}
	for (int i = 0; i < b; i++) {
		int t;
		cin >> t;
		if (s.count(t))
			s.erase(t);
	}

	cout << s.size() << "\n";
	for (int i : s) {
		cout << i << " ";
	}

	return 0;
}