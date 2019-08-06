#include <iostream>
#include <vector>
#include <algorithm>

using std::cout;
using std::vector;
using std::endl;
using std::min;

int minimizeCostOfMultiplication(vector<int> matrix_order){
    int gridSize = matrix_order.size();
    vector<vector<int>> operations(gridSize+1, vector<int> (gridSize+1));
    unsigned int i,j;
    for(i = 1; i<=gridSize+1; i++){
        for(j = 1; j<=gridSize+1; j++){
            if(i == j){
                operations[i][j] = 0;
            }
            
        }
    }
}

int main(){
    vector<int> matrix_order{4,10,3,12,20,7};
    minimizeCostOfMultiplication(matrix_order);
    return 0;
}