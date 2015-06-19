#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define BUFSIZE 2048

int main() {
    char text[BUFSIZE];
    int  len, i;
    int  count = 0;
    fgets(text, BUFSIZE, stdin);
    len = strlen(text);
    for (i=0; i<len; i++) {
        if (text[i] == 'a' || text[i] == 'A') {
            count++;
        }
    }

    printf("%d\n", count);

    return 0;
}
