#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

// size : required in mColoring.c
int size;
#include "mColoring.c"

int main(){

    int n_vertices = 0;
    // int n_edges = 0;
    int m;
    int *colorList;

    puts("Enter the number of vertices: ");
    scanf("%i", &n_vertices);

    size = n_vertices;
    // colorList : zero-indexing
    colorList = malloc(n_vertices * sizeof(int));

    int **adjList = malloc(n_vertices+1 * sizeof(int *));
    for(int i=0; i<=n_vertices; i++)
        adjList[i] = calloc(n_vertices, sizeof(int));

    puts("Enter the adjacent vertices number: ");
    for(int i=1; i<=n_vertices; i++){
        printf("Vertex-%i: \n", i);
        for(int j=0; j<n_vertices; j++){
            int temp;

            printf("%i: ", j);
            scanf("%i", &temp);

            // stop if 0 is entered
            if(!temp)
                break;

            adjList[i][j] = temp;
        }
    }
    
    puts("Enter the number of colors: ");
    scanf("%i", &m);

    // printing adjacency list:
    for(int i=1; i<=n_vertices; i++){
        for(int j=0; j<n_vertices; j++){
            // if(adjList[i][j])
                printf("%i ", adjList[i][j]);
        }
        puts("");
    }   

    if(!mColoring(adjList, colorList, m, 0))
        puts("Solution does not exist!");

    return 0;

}

/*
2
5
0
1
3
5
0
2
4
5
0
3
5
0
1
2
3
4
0


2
3
0
1
3
0
1
2
0

*/