#ifndef QUEUE_H
#define QUEUE_H

struct queueNode{
    int size;
    int front;
    int rear;
    struct treeNode **Q;
};

struct treeNode{
    struct treeNode* lChild;
    int data;
    struct treeNode* rChild;
};

void createQueue(struct queueNode*);
void enQueue(struct queueNode*, struct treeNode*);
struct treeNode* deQueue(struct queueNode*);
int isQueueEmpty(struct queueNode*);

#endif