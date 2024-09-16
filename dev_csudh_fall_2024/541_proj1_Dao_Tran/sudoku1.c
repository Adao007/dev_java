/*

Justine Tran
CSC-541-01
Fall 2024
Project #1: Sudoku Solution Validator

*/

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define MAX_LINES 9
#define MAX_NUMS_PER_LINE 9
#define MAX_LENGTH 100

/* this data is shared by the thread(s) */
bool rows = true;
bool columns = true;
bool squares = true;
int nums[MAX_LINES][MAX_NUMS_PER_LINE];
int line_count = 0;
int num_count[MAX_LINES] = {0};

/* threads call these function */
void *checkRows(void *param) {
        for (int i = 0; i < line_count; i++) {
                bool num_found[9] = {false};                                    // array of booleans used to keep track of what numbers are read
                // printf("row %d: ", i + 1);
                for (int j = 0; j < num_count[i]; j++) {
                        num_found[nums[i][j]-1] = true;                         // once a number is read in, its corresponding boolean is set to true
                }
                for (int k = 0; k < MAX_LINES; k++) {                           // checks the array of booleans to see if any are false (not found)
                        // printf("%d ", num_found[k]);
                        if (num_found[k] == false) {
                                rows = false;                                   // if any numbers are missing, row is not valid
                                pthread_exit(0);                                // thread exits as soon as a number is missing
                        }
                }
                // printf("\n");
        }
        pthread_exit(0);
}

void *checkColumns(void *param) {
       for (int i = 0; i < line_count; i++) {
                bool num_found[9] = {false};                                    // array of booleans used to keep track of what numbers are read
                // printf("column %d: ", i + 1);
                for (int j = 0; j < num_count[i]; j++) {
                        // printf("%d ", nums[j][i]);
                        num_found[nums[j][i]-1] = true;                         // once a number is read in, its corresponding boolean is set to true
                }
                // printf("\ncolumn %d: ", i + 1);
                for (int k = 0; k < MAX_LINES; k++) {                           // checks the array of booleans to see if any are false (not found)
                        // printf("%d ", num_found[k]);
                        if (num_found[k] == false) {                            
                                columns = false;                                // if any numbers are missing, column is not valid
                                pthread_exit(0);                                // thread exits as soon as a number is missing
                        }
                }
                // printf("\n");
        }
        pthread_exit(0);
}

void *checkSquares(void *param) {
        for (int i = 0; i < line_count; i=i+3) {                                // for loops used to jump to each subsquare
                for (int j = 0; j < line_count; j=j+3) {
                        bool num_found[9] = {false};                            // array of booleans used to keep track of what numbers are read
                        for (int k = 0; k < 3; k++) {                           // for loops to process each subsquare
                                // printf("square %d", i + 1);
                                // printf(".%d: ", k);
                                for (int l = 0; l < 3; l++) {
                                        // printf("%d", nums[i+k][j+l]);
                                        num_found[nums[i+k][j+l]-1] = true;     // once a number is read in, its corresponding boolean is set to true
                                }
                                // printf("\n");
                        }
                        // printf("\nsquares %d.%d: ", i + 1, j);
                        for (int m = 0; m < MAX_LINES; m++) {                   // checks the array of booleans to see if any are false (not found)
                                // printf("%d ", num_found[m]);
                                if (num_found[m] == false) {
                                        squares = false;                        // if any numbers are missing, square is not valid
                                        pthread_exit(0);                        // thread exits as soon as a number is missing
                                }
                        }
                        // printf("\n");
                }
        }
        pthread_exit(0);
}

// for checking/testing
void *printLines(void *param) {
        for (int i = 0; i < line_count; i++) {
                printf("Line %d: ", i + 1);
                for (int j = 0; j < num_count[i]; j++) {
                        printf("%d ", nums[i][j]);
                }
                printf("\n");
        }
        pthread_exit(0);
}

int main(int argc, char *argv[])
{
        char fileName[MAX_LENGTH];
        char line[MAX_LENGTH];

        printf("\nEnter file name: ");
        scanf("%s", fileName);                                                  // gets input file name from user

        FILE *file;
        file = fopen(fileName, "r");                                            // opens the input file

        if(file == NULL) {                                                      // checks if file opened successfully
                printf("Error opening file.\n");
                return 1;
        }
        else {
                printf("File opened.\n");
        }

        while (fgets(line, sizeof(line), file)) {                               // gets each line of input to processes one-by-one
                int curr_num;
                char *token;
                int num_index = 0;

                token = strtok(line, " ,");                                     // gets the next number, ignoring spaces and commas
                while (token != NULL) {                                         // continues while loop while there are still numbers
                        sscanf(token, "%d", &curr_num);                         // take string number and formats as a digit
                        nums[line_count][num_index] = curr_num;                 // puts numbers in a 2D array for easier processing
                        num_index++;
                        num_count[line_count]++;
                        token = strtok(NULL," ,");                              // resets the token
                }
                line_count++;
        }

        fclose(file);

        //---------------------------------------------------------
        // THREADS

        printf("\n");
        pthread_t tid1, tid2, tid3, tid4;
        pthread_attr_t attr1, attr2, attr3, attr4;

        // pthread_attr_init(&attr1);
        pthread_attr_init(&attr2);
        pthread_attr_init(&attr3);
        pthread_attr_init(&attr4);

        // Used for checking/testing
        /*
        pthread_create(&tid1, &attr1, printLines, argv[1]);
        pthread_join(tid1,NULL);
        printf("\n");
        */
        
        pthread_create(&tid2, &attr2, checkRows, argv[1]);
        pthread_create(&tid3, &attr3, checkColumns, argv[1]);
        pthread_create(&tid4, &attr4, checkSquares, argv[1]);

        // pthread_join(tid1,NULL);
        pthread_join(tid2,NULL);
        pthread_join(tid3,NULL);
        pthread_join(tid4,NULL);

        printf("Threads done.\n");

        // printf("rows: %d, columns: %d, squares: %d\n", rows, columns, squares);
        if (rows == false || columns == false || squares == false) {
                printf("Invalid Solution.\n\n");
        }
        else {
                printf("Valid Solution.\n\n");
        }

        return 0;
}