void printSolution(int *colorList){
    // int size = sizeof(colorList)/sizeof(int);
    printf("\nSolution: ");
    for(int i = 0; colorList[i]; i++)
        printf("%i ", colorList[i]);
}

int isSafe(int **adjList, int* colorList){

    // cannot calculate size like this :
    // sizeof(coloList) = 8 (sizeof(pointer))
    // sizeof(colorList)/sizeof(int) == 2
    // int size = sizeof(colorList)/sizeof(int);

    // for each vertex - 
    // gIndex - graphIndex ; cIndex - colorIndex
    for(int gIndex=1, cIndex=0; gIndex<size; gIndex++, cIndex++){
        // each neighbour -
        // nIndex - neighbourIndex
        for(int nIndex=0; adjList[gIndex][nIndex]; nIndex++){
            // return false if their color matches :
            // colorList : zero-indexing
            // colorList[index - 1] : here -1 is subtracted 
            if(colorList[cIndex] == colorList[adjList[gIndex][nIndex] - 1])
                return 0;
        }
    }

    return 1;

}


int mColoring(int **adjList, int *colorList, int m, int kIndex){

    if(kIndex == m){
        if(isSafe(adjList, colorList)){
            printSolution(colorList);
            return 1;
        }
        return 0;
    }

    for(int i = 1; i<=m; i++){
        colorList[kIndex] =  i;

        if(mColoring(adjList, colorList, m, kIndex+1)){
            return 1;
        }

        colorList[kIndex] = 0;
    }

    return 0;
}