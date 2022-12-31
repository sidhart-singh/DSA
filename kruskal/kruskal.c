#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

int findParent(int parent[], int i){
    while(parent[i] != -1)
        i = parent[i];

    return i;
}

int weightedUnion(int parent[], int i, int j){
    if(i != j){
        parent[j] = i;

        return 1;
    }

    return 0;
}

int main(){

    int n_vertices = 0;
    int n_edges = 0;

    puts("Enter the number of vertices: ");
    scanf("%i", &n_vertices);

    // costAdj Matrix with 'cost' where edge is present
    int **costAdj = malloc(n_vertices * sizeof(int *));
    for(int i = 0; i<n_vertices; i++)
        costAdj[i] = malloc(n_vertices * sizeof(int));

    int *parent = malloc(n_vertices * sizeof(int));

    // Intialize parent array to '-1'
    memset(parent, -1, n_vertices * sizeof(int));
    
    // Accept values in CostAdj Matrix
    puts("Enter the cost: ");
    for(int i = 0; i<n_vertices; i++){
        for(int j = i; j<n_vertices; j++){
            printf("%i:%i - ", i+1, j+1);
            scanf("%i", &costAdj[i][j]);
            // if: costAdj[i][j] == 0: No edge is present
            // then cost is assigned as maximum value
            if(costAdj[i][j] == 0)
                costAdj[i][j] = INT_MAX;
        }    
    }

    puts("Cost Adjecency Matrix: ");
    for(int i = 0; i<n_vertices; i++){
        for(int j = 0; j<n_vertices; j++){
            printf("%i:%i-%i ", i+1, j+1, costAdj[i][j]);
        }
        puts("");
    }

    int min;
    int min_cost;
    int min_cost_index1, min_cost_index2;

    while(n_edges < n_vertices){
        min = INT_MAX;
        for(int i = 0; i<n_vertices; i++){
            for(int j = i; j<n_vertices; j++){
                if(costAdj[i][j] < min){
                    // storing the minimum cost
                    min = costAdj[i][j];
                    // storing the index of minimum cost
                    min_cost_index1 = i;
                    min_cost_index2 = j;
                }
            }
        }

        // storing the parent of the vertices of the edge with minimum cost
        int parent1 = findParent(parent, min_cost_index1);
        int parent2 = findParent(parent, min_cost_index2);

        // weightedUnion operation on the parents:
        // if parents are not same : join them & include the edge int mst
        // else : they have the same parent & discard the edge
        if(weightedUnion(parent, parent1, parent2)){
            // print the edge
            // min_cost_index1+1, min_cost_index2+1 : they are zero-indexed
            printf("%i:edge(%i,%i)", ++n_edges, min_cost_index1+1, min_cost_index2+1, min);
            min_cost += min;
            parent[min_cost_index2] = min_cost_index1;
        }

        // updating cost of minimum edge with INT_MAX so its not included again
        // no need of a seperate "included[]"
        costAdj[min_cost_index1][min_cost_index2] = costAdj[min_cost_index2][min_cost_index1] = INT_MAX;
    }

    return 0;
}

/* 0
25
0
0
0
5
0
0
12
0
0
0
0
0
8
0
0
0
0
16
0
14
0
20
18
0
0
0 */