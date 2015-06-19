#include <stdio.h>

int main() {
    float sum = 0.0;
    int i;
    for (i=0; i<1000; i++) {
        sum = sum + 0.1;
    }

    printf("sum = %f\n", sum);

    return 0;
}
