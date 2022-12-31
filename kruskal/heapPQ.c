#include <stdio.h>
#include <stdlib.h>

int F = 1;
int R = 1;
int SIZE = 0;
// int *H = NULL;

struct HeapNode{
    int cost;
    int edge1;
    int edge2;
};

struct HeapNode* createHeap(int size){
    // H = malloc((size + 1) * sizeof(int));
    struct HeapNode* H = malloc((size + 1) * sizeof(struct HeapNode));
    
    // Initialising the dummy node : Not to be used
    H[0].cost = 0;
    H[0].edge1 = 0;
    H[0].edge2 = 0;
    
    SIZE = size;

    return H;
}

void enQueue(struct HeapNode H[]){

    int i = R+1;
    struct HeapNode temp = H[i];

    while(i > 1 && temp.cost < H[i/2].cost){

        H[i] = H[i/2];
        i /= 2;
    }

    H[i] = temp;

    // increment the rear pointer of the priority queue
    R++;
}

void makeHeap(struct HeapNode* H){

    for(int i = 2; i<SIZE; i++){
        enQueue(H);
    }
}

struct HeapNode deQueue(struct HeapNode* H){

    int i, j;  
    struct HeapNode deleted_element = H[F];
    
    struct HeapNode temp = H[R];
    H[F] = H[R];
    H[R] = deleted_element;

    i = F; j = i*2;

    // SIZE is reduced : SIZE - 1
    while(j < R - 1){
        if(H[j+1].cost < H[j].cost)
            j = j+1;
        
        if(H[i].cost > H[j].cost){
            temp = H[i];
            H[i] = H[j];
            H[j] = temp;
            i = j;
            j = 2*j;
        }else
            break;
    }

    // decrement the rear pointer of the priority queue : 
    // deleted element is stored at the rear
    R--;

    return deleted_element;
}