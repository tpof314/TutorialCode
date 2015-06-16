#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char str[1000];
    int  i;
    scanf("%s", str);
    
    for (i=0; i<strlen(str); i++) {
        if (str[i] < '0' || str[i] > '9') {
            printf("N\n");
            exit(0);
        }
    }
    
    printf("Y\n");
    return 0;
}
