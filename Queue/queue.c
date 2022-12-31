#include <stdlib.h>
#include "queue.h"

void queueCreate(struct queueNode *q, int size){
    q->size = size;
    q->front = q->rear = 0;
    q->Q = (struct treeNode**)malloc(q->size * sizeof(struct treeNode*));
}

void enQueue(struct queueNode *q, struct treeNode *x){
    if((q->rear + 1) % q->size == q->front)
        puts("Queue is full!");
    else{
        q->rear = (q->rear + 1) % q->size;
        q->Q[q->rear] = x;
    }
}

struct treeNode* deQueue(struct queueNode *q){
    struct treeNode *x = NULL;
    if(q->front == q->rear)
        puts("Queue is empty!");
    else{
        q->front = (q->front + 1) % q->size;
        x = q->Q[q->front];
    }
    return x;
}

int isQueueEmpty(struct queueNode *q){
    return q->front == q->rear;
}