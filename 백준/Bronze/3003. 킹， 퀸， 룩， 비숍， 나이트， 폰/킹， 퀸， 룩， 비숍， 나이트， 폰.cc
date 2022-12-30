#include <stdio.h>
int main(void)
{
    int set[6] = {1, 1, 2, 2, 2, 8};
    int now[6];
    
    for (int i = 0; i < 6; i++)
        scanf("%d", &now[i]);
    
    for (int i = 0; i < 6; i++)
        printf("%d ", set[i] - now[i]);
    
    return 0;
}