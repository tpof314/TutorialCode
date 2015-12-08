#include <stdio.h>

int main() {
    double cel;
    double far;
    printf("请输入华氏温度：");
    scanf("%lf", &far);
    cel = (far - 32) * 5 / 9;
    printf("%.3f 华氏度 = %.3f 摄氏度\n", far, cel);
    
    return 0;
}
