#include <stdio.h>
#include <stdlib.h>

// #define N 6

struct job{
    int ID;
    int profit;
    int dl;
};

/* 
    Scheduled Job List
    with an "isEmpty" field for checking while assigning
*/
struct jobSchedule{
    struct job job;
    int isEmpty;
};

// void swap(struct item* item1, struct item* item2){
//     float temp;

//     temp = item1->itemID;
//     item1->itemID = item2->itemID;
//     item2->itemID = (int)temp;

//     temp = item1->price;
//     item1->price = item2->price;
//     item2->price = temp;
    
//     temp = item1->weight;
//     item1->weight = item2->weight;
//     item2->weight = temp;

//     temp = item1->ppw;
//     item1->ppw = item2->ppw;
//     item2->ppw = temp;
// }

// int partition(struct item* item_info, int low, int high){
//     int second_pointer;
//     float pivot = item_info[high].ppw;
//     int i = (low -1);

//     for(int j = low; j < high; j++){
//         if(item_info[j].ppw > pivot){
//             i++;
//             swap(&item_info[i], &item_info[j]);
//         }
//     }
//     swap(&item_info[i+1], &item_info[high]);
    
//     return i+1;
// }

// void quickSort(struct item* item_info, int low, int high){
//     if(low < high){
//         int partition_index = partition(item_info, low, high);
//         quickSort(item_info, low, partition_index - 1);
//         quickSort(item_info, partition_index + 1, high);
//     }
// }

void sortProfit(struct job* job_list, int n){
    int i;
    int j;
    struct job dummy_job;

    /* for(i = 1; i<n; i++){
        dummy_job = job_list[i];

        for(j = i - 1; (j >= 0) && (job_list[j].profit) < (dummy_job.profit); j--){
            job_list[j + 1] = job_list[j];
        }

        job_list[j + 1] = dummy_job;
    } */

    /* QuicKSort: (Iterative) */
    int pivot, temp;
    for(i = 0; i<n-1; i++){
        pivot = i;
        for(j = i+1; j<n; j++){
            if(job_list[j].profit > job_list[pivot].profit)
                pivot = j;
        }
        
        if(pivot != 1){
            temp = job_list[i].ID;
            job_list[i].ID = job_list[pivot].ID;
            job_list[pivot].ID = temp;

            temp = job_list[i].profit;
            job_list[i].profit = job_list[pivot].profit;
            job_list[pivot].profit = temp;

            temp = job_list[i].dl;
            job_list[i].dl = job_list[pivot].dl;
            job_list[pivot].dl = temp;
        }
    }

    /*  */


}

void jobScheduling(struct job *job_list, struct jobSchedule *job_sol_list, int n){

    for(int i = 0; i<n; i++){

        for(int j = job_list[i].dl - 1; j >= 0; j--){

            if(job_sol_list[j].isEmpty){
                job_sol_list[j].job = job_list[i];
                job_sol_list[j].isEmpty = 0;
                break;
            }
        }
    }

}

void display(struct job* job_list, int n){

    puts("JobID:");
    for(int i = 0; i<n; i++)
        printf("%i ", job_list[i].ID);

    puts("\nProfit:");
    for(int i = 0; i<n; i++)
        printf("%i ", job_list[i].profit);

    puts("\nDeadline:");
    for(int i = 0; i<n; i++)
        printf("%i ", job_list[i].dl);

    puts("");
}

void display1(struct jobSchedule* job_sol_list, int n){

    puts("JobID:");
    for(int i = 0; i<n; i++)
    /* Print the slots which are not empty | There may be empty slots after job scheduling */
        if(!job_sol_list[i].isEmpty)
            printf("%i ", job_sol_list[i].job.ID);

    // puts("\nProfit:");
    // for(int i = 1; i<n; i++)
    //     printf("%i ", job_list[i].profit);

    // puts("\nDeadline:");
    // for(int i = 1; i<n; i++)
    //     printf("%i ", job_list[i].dl);

}

int main(){
    int n;

    puts("Enter the number of jobs: ");
    scanf("%i", &n);

    struct job *job_list;
    // struct job *job_sol_list;
    job_list = malloc(n *  sizeof(struct job));
    // job_sol_list = malloc((n+1) * sizeof(struct job));


    struct jobSchedule *job_sol_list = malloc(n * sizeof(struct jobSchedule));
    /* Assign isEmpty field to false: */
    for(int i = 0; i<n; i++){
        job_sol_list[i].isEmpty = 1;
    }


    /* Fill Job List: */
    for(int i = 0; i<n; i++){
        job_list[i].ID = (i+1);
        
        printf("Enter profit for job:%i ", i+1);
        scanf("%i", &job_list[i].profit);

        printf("Enter deadline for job:%i ", i+1);
        scanf("%i", &job_list[i].dl);
    }    

    sortProfit(job_list, n);

    display(job_list, n);

    // /* Initializing dummy job: */
    // job_sol_list[0].ID = 0;
    // job_sol_list[0].profit = 0;
    // job_sol_list[0].dl = 0;

    // /* Assinging first job: */
    // job_sol_list[1] = job_list[0];

    // int size = 1;
    // for(int i = 1; i<n; i++){
    //     int r = size;
    //     int j;
    //     while((job_sol_list[r].dl) > (job_list[i].dl) && (job_sol_list[r].dl != r)){
    //         r--;
    //     }
    //     if((job_sol_list[r].dl) <= (job_list[i].dl) && (job_sol_list[i].dl < r)){

    //         for(j = size; j>=r+1; j-- )
    //             job_sol_list[j+1] = job_sol_list[j];

    //         job_sol_list[j+1] = job_list[i];
    //         size++;
            
    //     }
    // }

    jobScheduling(job_list, job_sol_list, n);

    display1(job_sol_list, n);

    return 0;
}