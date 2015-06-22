#include <stdio.h>
#define SIZE 81

int main() {
    int arr[SIZE];
    int i;
    int max, min;
    
    FILE* file = fopen("data02.txt", "r");
    for (i=0; i<SIZE; i++) {
        fscanf(file, "%d", &arr[i]);
    }
    
    for (i=0; i<SIZE; i++) {
        printf("%4d", arr[i]);
        if ((i+1) % 9 == 0) {
            printf("\n");
        }
    }
    
    return 0;
}