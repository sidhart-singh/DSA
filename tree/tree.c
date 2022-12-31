#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include "queue.c"

// struct treeNode{
//     struct treeNode* lChild;
//     int data;
//     struct treeNode* rChild;
// };

struct treeNode* root = NULL;

void createTree(struct treeNode*);
void preOrder(struct treeNode*);
void inOrder(struct treeNode*);
void postOrder(struct treeNode*);

void createTree(struct treeNode* root){

    struct queueNode q;
    struct treeNode *p;
    struct treeNode *t;
    int x;
    
    queueCreate(&q, 50);

    puts("Enter the value in root: ");
    scanf("%i", &x);

    root = (struct treeNode*)malloc(sizeof(struct treeNode));
    root->data = x;
    root->lChild = root->rChild = NULL;

    enQueue(&q, root);

    while(!isQueueEmpty(&q)){
        p = deQueue(&q);

        printf("Enter left child of %i: ", p->data);
        scanf("%i", &x);

        if(x != -1){
            t = (struct treeNode*)malloc(sizeof(struct treeNode));
            t->data = x;
            t->lChild = t->rChild = NULL;
            p->lChild = t;
            enQueue(&q, t);
        }

        printf("Enter right child of %i: ", p->data);
        scanf("%i", &x);

        if(x != -1){
            t = (struct treeNode*)malloc(sizeof(struct treeNode));
            t->data = x;
            t->lChild = t->rChild = NULL;
            p->rChild = t;
            enQueue(&q, t);
        }
    }
}

void preOrder(struct treeNode* p){
    if(p){
        printf("%i ", p->data);
        preOrder(p->lChild);
        preOrder(p->rChild);
    }
}

int main(){

    createTree(root);
    preOrder(root);

    return 0;
}

