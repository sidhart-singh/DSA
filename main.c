#include <stdio.h>
#include <stdlib.h>
// #include "bst.h"
// #include "avlt.c"
#include "Heap/heap.c"

int main(){
    /* 
    struct bstNode* root = NULL;

    root = bstInsert(root, 10);
    bstInsert(root, 5);
    bstInsert(root, 50);
    bstInsert(root, 20);
    bstInsert(root, 45);
    bstInsert(root, 25);
    bstInsert(root, 40);
    bstInsert(root, 30);
    bstInsert(root, 35);

    puts("Before delete: ");
    bstInorder(root);

    //  if(bstSearch(root, 5))
    //     puts("Found");
    // else
    //     puts("Not Found"); 

    puts("\nAfter delete: ");
    bstDelete(root, 5);

    bstInorder(root);
 */
/* 
    root=RInsert(root,50);
    RInsert(root, 30);
    RInsert(root,10);
    RInsert(root,20);
 */

    // for(int i = 1;)

    int *H = createHeapPQ(10);

    puts("Original Array: ");
    for(int i = 0; i<=10; i++){
        H[i] = 11 - i;
        printf("%i ", H[i]);
        if(i > 1)
            enqueue(H);
    }

    // makeHeapPQ(H);

    puts("\nAfter makeHeaP(): ");
    for(int i = 0; i<=10; i++){
        printf("%i ", H[i]);
    }

    for(int i = 1; i<=10; i++)
        deQueue(H);

    puts("\nAfter deQueue: HeapSort: ");
    for(int i = 0; i<=10; i++){
        printf("%i ", H[i]);
    }

    return 0;
}