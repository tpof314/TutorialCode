#include <stdio.h>

int main() {
    int x = 20;
    int y = 10;
    int min = y ^ ( (x^y) & -(x<y) );
    
    printf("min = %d\n", min);
    
}