#include <stdio.h>
int main() {
    int N;
    int arr[100];
    int v;
    int cnt = 0;
 
    scanf("%d", &N);
 
    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }
 
    scanf("%d", &v);
 
    for (int j = 0; j < N; j++) {
        if (arr[j] == v)
            cnt++; 
    }
 
    printf("%d", cnt);
}
