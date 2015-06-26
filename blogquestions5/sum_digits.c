#include <stdio.h>
#include <string.h>

int main() {
    char str[2048];
    int i, sum = 0;
    int len;
    fgets(str, sizeof(str), stdin);
    
    len = strlen(str);
    for (i=0; i<len; i++) {
        if (str[i] >= '0' && str[i] <= '9') {
            sum = sum + str[i] - '0';
        }
    }
    
    printf("sum = %d\n", sum);
    return 0;
}
