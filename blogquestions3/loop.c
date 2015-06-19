#include <stdio.h>

int main() {
    int num;
    int i;
    scanf("%d", &num);
    for (i=1; i<=num; i++) {
        if (i % 2 == 0) {
            printf("%d\n", -i);
        }
        else {
            printf("%d\n", i);
        }
    }
    return 0;
}
