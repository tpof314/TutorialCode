#include <stdio.h>
#include <stdlib.h>

// 一个链表节点的结构
typedef struct node {
    int          data;      // 数据
    struct node* last;      // 前一个数据节点
    struct node* next;      // 后一个数据节点
} Node;

typedef struct {
    Node* head;
    Node* tail;
} LinkedList;

// 完成下面所有未实现的函数
// 题目讲解可以看这段视频：http://www.tudou.com/programs/view/OAlRHNWcrrw/
/**
 * 新建一个空的链表.
 */
LinkedList* newList() {

}

/**
 * 在头节点的前面添加一个节点，
 * 值为num.
 */
void addNodeBeforeHead (LinkedList* list, int num) {

}

/**
 * 在尾节点的后面添加一个节点，
 * 值为num.
 */
void addNodeAfterTail (LinkedList* list, int num) {

}

/**
 * (新添加的函数)
 *  统计一下整个链表list中一共
 *  有多少个节点
 */
int countNodes (LinkedList* list) {

}

/**
 * (新添加的函数)
 * 把链表转换成数组，并返回.
 * 【例】如果链表是5 -> 6 -> 8 ->
 * 10 -> 11 -> NULL，那么转换后的
 * 数组就是{5, 6, 8, 10, 11}
 *【提示】新建数组的时候一定要用到
 * malloc，否则没办法返回。
 */
int* listToArray (LinkedList* list) {

}

/**
 * 新建一个大小为n的链表.
 * 如果n = 5的话，
 * 那么这个链表有5个节点，
 * 并且，里面的值是：
 * 1 -> 2 -> 3 -> 4 -> 5 ->
 * NULL
 */
LinkedList* newListWithValues (int n) {

}

/**
 * 把所有的链表节点头尾对调，
 * 比方说，如果链表一开始是：
 * 1 -> 2 -> 3 -> 4 -> 5 ->
 * NULL
 * 那么对调会就是：
 * 5 -> 4 -> 3 -> 2 -> 1 ->
 * NULL
 */
void reverseList (LinkedList* list) {

}

/**
 * 找出链表节点中最大的值，并返回.
 */
int findMaxValue (LinkedList* list) {

}

/**
 * 找出链表节点中最小的值，并返回.
 */
int findMinValue (LinkedList* list) {

}

/**
 * 计算出链表中所有节点的平均值.
 */
float computeAverage (LinkedList* list) {

}

/**
 *  (新添加的函数)
 * 把链表的头节点删除掉，
 * 并返回头结点上面的数字.
 */
int popHead (LinkedList* list) {

}

/**
 * (新添加的函数)
 * 把链表的尾节点删除掉，
 * 并返回头结点上面的数字.
 */
int popTail (LinkedList* list) {

}

/**
 * (新添加的函数)
 * 查找链表节点.
 * 查看链表中是不是
 * 有包含data这个数据，
 * 有的话，返回节点.
 * 没有的话，返回NULL.
 */
Node* findNode (LinkedList* list, int data) {

}

/*
 * 打印链表
 */
void displayList(LinkedList* list) {

}

int main () {
    return 0;
}
