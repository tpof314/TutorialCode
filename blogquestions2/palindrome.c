#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char str[1000];
    int  i, len;
    int  L, R;
    printf("请输入一个单词：\n");
    scanf("%s", str);
    
    len = strlen(str);
    for (i = 0; i < len/2; i++) {
        if (str[i] != str[len-i-1]) {
            printf("不是回文\n");
            exit(0);
        }
    }
    
    printf("回文\n");
    return 0;
}
