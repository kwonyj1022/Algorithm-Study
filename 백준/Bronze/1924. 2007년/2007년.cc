#include <stdio.h>

int main()
{
	int month[13] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	int x, y;
	scanf("%d %d", &x, &y);

	int day = 0;
	for (int i = 1; i < x; i++)
		day += month[i];
	day += y - 1;

	if (day % 7 == 0)
		printf("MON");
	else if (day % 7 == 1)
		printf("TUE");
	else if (day % 7 == 2)
		printf("WED");
	else if (day % 7 == 3)
		printf("THU");
	else if (day % 7 == 4)
		printf("FRI");
	else if (day % 7 == 5)
		printf("SAT");
	else
		printf("SUN");

	return 0;
}