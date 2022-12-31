#include <stdio.h>
#include <stdlib.h>

/* MIN - HEAP IMPLEMENTATION */
/* 
    For MAX - HEAP:

    1. Inside enqueue():
        while(i > 1 && temp > H[i])

    2. Inside dequeue():
        if(H[j+1] > H[j])

    3. Insid dequeue():
        if(H[i] < H[j])

 */

// zero-th index is ignored
// First element is considered to be in the heap : F = R = 1
int F = 1;
int R = 1;
int SIZE = 0;
// int *H = NULL;

// struct HeapNode{
//     int cost;
//     int edge1;
//     int edge2;
// };

int* createHeapPQ(int size){
    int *H = malloc((size + 1) * sizeof(int));
    // struct HeapNode* H = malloc((size + 1) * sizeof(struct HeapNode));
    
    // maintain size globally
    SIZE = size;

    return H;
}

void enqueue(int H[]){
    // i : index of element to be included in the heap
    // R : index of last element in the heap : rear pointer
    int i = R+1;

    // n : passed as "i" from makeHeapPQ(H, i) 
    // not needed : R (rear pointer) is maintained
    // int i = n;
    int temp = H[i];

    while(i > 1 && temp < H[i/2]){

        H[i] = H[i/2];
        i /= 2;
    }

    H[i] = temp;

    // increment the rear pointer of the priority queue
    R++;
}

void makeHeapPQ(int H[]){

    // make a whole array of elements into a heap
    for(int i = 2; i<=SIZE; i++){
        enqueue(H);
    }
}

int deQueue(int H[]){

    int i, j, temp;
    
    // storing the element to be deleted : H[F : front]
    int deleted_element = H[F];
    
    // swapping h[F] with the last element in the heap: H[R: rear]
    temp = H[R];
    H[F] = H[R];
    H[R] = deleted_element;

    i = F;
    j = i*2;

    // SIZE of the heap is reduced : SIZE - 1
    while(j < R - 1){
        // left and right children are compared : 
        // get the "smaller : (minHeap)" of the two
        if(H[j+1] < H[j])
            j = j+1;
        
        // if H[i] is greater than the smaller child(H[j]) : 
        // swap them
        // increment i and j to the next level : pair of children to be checked
        if(H[i] > H[j]){
            temp = H[i];
            H[i] = H[j];
            H[j] = temp;
            i = j;
            j = 2*j;
        }else
            // stop when H[i] is not greater than the smaller child
            break;
    }

    // decrement the rear pointer of the priority queue : 
    // deleted element is stored at the rear
    R--;
}