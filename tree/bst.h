#include <stdio.h>
#include <stdlib.h>

struct bstNode{
    struct bstNode* lChild;
    int value;
    struct bstNode* rChild;
};

struct bstNode* bstSearch(struct bstNode* root, int key){
    if(!root)
        return 0;
    
    if(root->value == key)
        return  root;
    else if(root->value > key)
        bstSearch(root->lChild, key);
    else
        bstSearch(root->rChild, key);
}

struct bstNode* bstInsert(struct bstNode* root, int value){
    struct bstNode* newNode = NULL;
    if(!root){
        newNode = (struct bstNode*)malloc(sizeof(struct bstNode));
        newNode->value = value;
        newNode->lChild = newNode->rChild = NULL;

        return newNode;
    }

    if(root->value == value)
        return NULL;
    else if(root->value > value)
        root->lChild = bstInsert(root->lChild, value);
    else
        root->rChild = bstInsert(root->rChild, value);

}

void bstInorder(struct bstNode* root){
    if(!root)
        return;

    bstInorder(root->lChild);
    printf(" %i ", root->value);
    bstInorder(root->rChild);

}


struct bstNode* inPre(struct bstNode* node){
	if(!node)
		return NULL;
	
	while(node->rChild)
		node = node->rChild;

	return node;
}

struct bstNode* inSuc(struct bstNode* node){
	if(!node)
		return NULL;
	
	while(node->lChild)
		node = node->lChild;

	return node;
}

struct bstNode* bstDelete(struct bstNode* root, int key){
	struct bstNode* inorderNode = NULL;
	
	if(!root)
		return NULL;
	
	if(root->value == key){
		if(root->lChild){
			inorderNode = inPre(root->lChild);
			root->value = inorderNode->value;

			root->lChild = bstDelete(root->lChild, inorderNode->value);
		}else if(root->rChild){
			inorderNode = inSuc(root->rChild);
			root->value = inorderNode->value;
			root->rChild = bstDelete(root->rChild, inorderNode->value);
		}else{
			free(root);
			return NULL;
		}
	}else if(root->value > key){
		root->lChild = bstDelete(root->lChild, key);
	}else if(root->value < key){
		root->rChild = bstDelete(root->rChild, key);
	}

	return root;
}

