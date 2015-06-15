#include <stdio.h>

int main( void ) {
    double height;
    double inch;
    printf("请输入一个高度（厘米）: ");
    scanf("%lf", &height);
    inch = height / 2.54;
    printf("转换成英寸是：%.2lf\n", inch);
    
    return 0;
}