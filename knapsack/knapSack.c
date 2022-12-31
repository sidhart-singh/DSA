#include <stdio.h>
#include <stdlib.h>

struct item{
    int itemID;
    float price;
    float weight;
    float ppw;
};

// int comp(const void* i, const void* j){
//     return *(float *)j - *(float *)i;
// }
/* 
void sortDescending(struct item* item_info, int low, int high){
    int left_index = low;
    int right_index = high;

    int pivot = item_info[(low + high) / 2].ppw;
    int temp1;
    float temp2, temp3, temp4;

    do{
        while((item_info[left_index].ppw > pivot))
            left_index++;
        
        while((item_info[right_index].ppw < pivot))
            right_index++;

        if(left_index <= right_index){
            temp1 = item_info[left_index].itemID;
            temp2 = item_info[left_index].price;
            temp3 = item_info[left_index].weight;
            temp4 = item_info[left_index].ppw;

            item_info[left_index].itemID = item_info[right_index].itemID;
            item_info[left_index].price = item_info[right_index].price;
            item_info[left_index].weight = item_info[right_index].weight;
            item_info[left_index].ppw = item_info[right_index].ppw;

            item_info[right_index].itemID = temp1;
            item_info[right_index].price = temp2;
            item_info[right_index].weight = temp3;
            item_info[right_index].ppw = temp4;

            left_index++;
            right_index--;
        }
    }while(left_index <= right_index);

    if(low < right_index)
        sortDescending(item_info, low, right_index);
    if(left_index < high)
        sortDescending(item_info, left_index, high);
}
 */

void swap(struct item* item1, struct item* item2){
    float temp;

    temp = item1->itemID;
    item1->itemID = item2->itemID;
    item2->itemID = (int)temp;

    temp = item1->price;
    item1->price = item2->price;
    item2->price = temp;
    
    temp = item1->weight;
    item1->weight = item2->weight;
    item2->weight = temp;

    temp = item1->ppw;
    item1->ppw = item2->ppw;
    item2->ppw = temp;
}

int partition(struct item* item_info, int low, int high){
    int second_pointer;
    float pivot = item_info[high].ppw;
    int i = (low -1);

    for(int j = low; j < high; j++){
        if(item_info[j].ppw > pivot){
            i++;
            swap(&item_info[i], &item_info[j]);
        }
    }
    swap(&item_info[i+1], &item_info[high]);
    
    return i+1;
}

void quickSort(struct item* item_info, int low, int high){
    if(low < high){
        int partition_index = partition(item_info, low, high);
        quickSort(item_info, low, partition_index - 1);
        quickSort(item_info, partition_index + 1, high);
    }
}

float knapSack(struct item* item_info, float capacity, int n){

    float profit = 0;
    float current_capacity = capacity;
    int i = 0;

    while(current_capacity > 0){
        if(item_info[i].weight <= current_capacity){
            profit = item_info[i].price;
            current_capacity -= item_info[i].weight;
        }else{
            profit += item_info[i].ppw * current_capacity;
            current_capacity = 0;
        }
        i++;
    }

    return profit;
}

int main(){

    int n_items;
    float capacity;

    puts("Enter the number of items: ");
    scanf("%i", &n_items);
    
    puts("Enter capacity: ");
    scanf("%f", &capacity);

    struct item* item_info = malloc(n_items * sizeof(struct item));

    puts("Enter the info - weight:price : ");
    for(int i = 0; i<n_items; i++){
        printf("Item:-%i: \n", i+1);
        scanf("%f", &item_info[i].weight);
        scanf("%f", &item_info[i].price);
    }

    for(int i = 0; i<n_items; i++){
        item_info[i].itemID = i+1;
        item_info[i].ppw = item_info[i].price / item_info[i].weight;
    }

    // qsort(item_info, n_items, sizeof(struct item), comp);
    // sortDescending(item_info, 0, n_items - 1);
    quickSort(item_info, 0, n_items-1);

    puts("item Info: ");
    for(int i = 0; i<n_items; i++){
        printf("\nItem:-%i\n", i+1);
        printf("itemID: %i ", item_info[i].itemID);
        printf("Weight: %.2f ", item_info[i].weight);
        printf("Price: %.2f ", item_info[i].price);
        printf("Price per Weight: %.2f", item_info[i].ppw);
    }

    printf("\nTotal Profit: %f", knapSack(item_info, capacity, n_items));

    return 0;
}