#include <stdio.h>

int main() {
    int i, j;
    for (i=0; i<5; i++) {
        
        for (j=0; j<4-i; j++) {
            printf(" ");
        }
        
        if (i == 0) {
            printf("*");
        }
        else {
            printf("*");
            for (j=0; j<2*i-1; j++) {
                printf(" ");
            }
            printf("*");
        }
        printf("\n");
    }
    
    for (i=3; i>=0; i--) {
        
        for (j=0; j<4-i; j++) {
            printf(" ");
        }
        
        if (i == 0) {
            printf("*");
        }
        else {
            printf("*");
            for (j=0; j<2*i-1; j++) {
                printf(" ");
            }
            printf("*");
        }
        printf("\n");
    }
    return 0;
}