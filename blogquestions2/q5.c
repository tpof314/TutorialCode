#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char text[1000];
    int  i;
    scanf("%s", text);
    
    for (i=0; i<strlen(text); i++) {
        if (text[i] < '0' || text[i] > '9') {
            printf("N\n");
            exit(0);
        }
    }
    
    printf("Y\n");
    return 0;
}
