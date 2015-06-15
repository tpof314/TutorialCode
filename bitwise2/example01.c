#include <stdio.h>

int unsetNthBit(int value, int n) {
    int result = ~(1 << n) & value;
    return result;
}

int setNthBit(int value, int n) {
    int result = (1 << n) | value;
    return result;
}

void toBinary(int value) {
    int count = 0;
    int copy = value;
    int i;
    while (value > 0) {
        count++;
        value = value >> 1;
    }
     
    for (i = count-1; i>=0; i--) {
        int bit = ((1<<i)&copy)>>i;
        printf("%d", bit);
    }
    printf("\n");
}

int main() {
    int value = 167;
    toBinary(value);
    
    int result = unsetNthBit(value, 5);
    toBinary(result);


}
