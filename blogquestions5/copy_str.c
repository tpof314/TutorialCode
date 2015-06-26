#include <stdio.h>

int main() {
    char str1[1024] = "This is an sample text";
    char str2[1024];
    char *p_str1;
    char *p_str2;
    
    p_str1 = &str1[0];
    p_str2 = &str2[0];
    while (*p_str1 != '\0') {
        *p_str2 = *p_str1;
        p_str1++;
        p_str2++;
    }
    p_str2 = '\0';
    
    printf("str1 = %s\n", str1);
    printf("str2 = %s\n", str2);
    return 0;

}