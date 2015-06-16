#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char str[1000];
    int  i;
    printf("请输入一段文字：\n");
    fgets(str, 1000, stdin);
    
    for (i=0; i<strlen(str); i++) {
        if (str[i] >= 'a' && str[i] <= 'z') {
            str[i] = str[i] - ('a' - 'A');
        }
    }
    
    printf("转换结果：\n");
    printf("%s\n", str);
    return 0;
}
