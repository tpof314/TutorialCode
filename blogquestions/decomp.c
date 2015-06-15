#include <stdio.h>

int main() {
    int num;
    printf("请输入一个整数：");
    scanf("%d", &num);
    
    while (num > 0) {
        printf("%d\n", num % 10);
        num = num / 10;
    }
    
    return 0;
}
