#include <stdio.h>
#define SIZE 100

int main() {
    int arr[SIZE];
    int i;
    int max, min;
    
    FILE* file = fopen("data01.txt", "r");
    for (i=0; i<SIZE; i++) {
        fscanf(file, "%d", &arr[i]);
    }
    
    max = arr[0];
    min = arr[0];
    
    for (i=0; i<SIZE; i++) {
        if (arr[i] > max) { max = arr[i]; }
        if (arr[i] < min) { min = arr[i]; }
    }
    
    printf("max = %d\n", max);
    printf("min = %d\n", min);
}