#include <stdio.h>
#include <string.h>
#define SIZE 12

int main() {
    int weights[SIZE] = {1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3};
    int digits[SIZE];
    char text[100];
    int i = 0;  int j = 0;
    scanf("%s", text);
    
    // 1. Find the digits from user's input
    int len = strlen(text);
    for (i = 0; i < len; i++) {
        if (text[i] != '-') {
            digits[j] = text[i] - '0';
            j++;
        }
    }
    
    // 2. Calculate check sum
    int sum = 0;
    int checksum = 0;
    for (i=0; i<SIZE; i++) {
        sum = sum + weights[i] * digits[i];
    }
    checksum = 10 - (sum % 10);
    
    // 3. Replace the last digit in the input text
    text[len - 1] = checksum + '0';
    printf("%s\n", text);
}