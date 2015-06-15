#include <stdio.h>

int main() {
    int a = 10;
    int b = 5;
    
    /*
    int temp = a;
    a = b;
    b = temp;
    */
    
    a = a ^ b;
    b = b ^ a;
    a = a ^ b;
    
    printf("a = %d\n", a);
    printf("b = %d\n", b);
    
}