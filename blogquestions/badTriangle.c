#include <stdio.h>

int main( void ) {
    int a, b, c;
    printf("请输入三边长度: ");
    scanf("%d %d %d", &a, &b, &c);
    if (a+b>c && a+c>b && b+c>a) {
        printf("YES\n");
    }
    else {
        printf("NO\n");
    }
    
    return 0;
}