#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
using namespace std;

int N, M;
vector<string> V;
map<string, int> C;

bool Compare(const string &a, const string &b) {
    if (C[a] != C[b])
        return C[a] > C[b];
    if (a.size() != b.size())
        return a.size() > b.size();
    return a < b;
}

int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    
    cin >> N >> M;
    V.resize(N);
    for (string &i : V) {
        cin >> i;
        C[i]++;
    }
    sort(V.begin(), V.end());
    V.erase(unique(V.begin(), V.end()), V.end());
    sort(V.begin(), V.end(), Compare);
    for (const string &i : V)
        if (i.size() >= M)
            cout << i << "\n";   
}