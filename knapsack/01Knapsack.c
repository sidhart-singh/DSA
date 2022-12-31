#include <stdio.h>
#include <limits.h>
#include <stdlib.h>
#include <string.h>

/* MEMOIZATION */
int **t;

int max(int i, int j){
    return (i>j) ? i : j;
}

int recknapsack(int wt[], int val[], int w, int n){

    if(n==0 || w==0)
        return 0;

    int taken;
    int not_taken;

    if(wt[n-1] <= w){

        // return max( val[n-1] + knapsack(wt, val, w-wt[n-1], n-1),
        //             knapsack(wt, val, w, n-1));

        taken = val[n-1] + recknapsack(wt, val, w-wt[n-1], n-1);
        not_taken = recknapsack(wt, val, w, n-1);

        return max(taken, not_taken);

    }else if(wt[n-1] > w){
        // return knapsack(wt, val, w, n-1);

        not_taken = recknapsack(wt, val, w, n-1);

        return not_taken;
    }

}

int memoknapsack(int wt[], int val[], int w, int n){

    if(n==0 || w==0)
        return 0;

    // return result if the same instance of the sub problem is already solves and stored
    if(t[n][w] != -1)
        return t[n][w];

    if(wt[n-1] <= w){

        // return and store new instances of the subproblem which are solved
        return t[n][w] = max(   val[n-1] + memoknapsack(wt, val, w-wt[n-1], n-1),
                                memoknapsack(wt, val, w, n-1));

    }else if(wt[n-1] > w){

        // return and store new instances of the subproblem which are solved
        return t[n][w] = memoknapsack(wt, val, w, n-1);

    }

}

int main(){

    int n_items = 4;
    int capacity = 15;
    int weight[] = {3, 5, 9, 1};
    int value[] = {20, 10, 30, 15};

    // creating storage for storing result of subproblems to be accessed if same instance is encountered
    t = malloc(n_items+1 * sizeof(int *));
    for(int i = 0; i<n_items+1; i++)
        t[i] = malloc(capacity+1 * sizeof(int));

    // initialising the table to '-1'
    memset(t, -1, sizeof(t));


    printf("Max value: %i", memoknapsack(weight, value, capacity, n_items));
    // printf("Max value: %i", recknapsack(weight, value, capacity, n_items));

    return 0;
}