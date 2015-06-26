#include <stdio.h>
#include <string.h>

// 3. 写一个函数isdigit()，判断一个字符是不是数字字符.
int isDigit(char ch) {
    if (ch >= '0' && ch <= '9') {
        return 1;
    }
    else {
        return 0;
    }
}

// 4. 写一个函数isAlphabet()，判断一个字符是不是字母.
int isAlphabet(char ch) {
    if (ch >= 'A' && ch <= 'Z') {
        return 1;
    }
    else if (ch >= 'a' && ch <= 'z') {
        return 1;
    }
    else {
        return 0;
    }
}

// 5. 写一个函数reverse()，将一个字符串中的内容倒置过来
void reverse(char text[]) {
    int len = strlen(text);
    char left  = 0;
    char right = len - 1;
    char temp;
    
    while (left < right) {
        temp = text[left];
        text[left] = text[right];
        text[right] = temp;
        left++;
        right--;
    }
}


// main函数测试
int main() {
    char text[1024] = "ABCDEFG";
    
    printf("test1: %d\n", isDigit('a'));
    printf("test1: %d\n", isDigit('b'));
    printf("test1: %d\n", isDigit('0'));
    printf("test1: %d\n", isDigit('9'));
    printf("test1: %d\n", isDigit('?'));
    printf("================\n");
    
    printf("test2: %d\n", isAlphabet('a'));
    printf("test2: %d\n", isAlphabet('b'));
    printf("test2: %d\n", isAlphabet('0'));
    printf("test2: %d\n", isAlphabet('9'));
    printf("test2: %d\n", isAlphabet('?'));
    printf("================\n");
    
    reverse(text);
    printf("test3: %s\n", text);
}