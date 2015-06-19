#include <stdio.h>

int main() {
    int n, i, temp;
    int a = 1;
    int b = 1;
    scanf("%d", &n);
    if (n == 1) {
        printf("%d\n", 1);
    }
    else if (n == 2) { 
        printf("1\n");
        printf("1\n");
    }
    else {
        printf("1\n");
        printf("1\n"); 
        for (i=2; i<n; i++) {
            temp = a + b;
            printf("%d\n", temp);
            a = b;
            b = temp;
        }
    }
    return 0;
}
