#include <iostream>
#include <vector>

using std::cout;
using std::vector;
using std::endl;

bool subsetSUm(vector<int> arr, int sum){
    vector<vector<int>> subset(arr.size(),vector<int> (sum));
    unsigned int i,j;
    for(i = 0; i<arr.size(); i++){
        subset[i][0] = true;
    }
    for(i = 1; i < arr.size(); i++){
        for(j = 1; j < sum +1; j++){
            if(j - arr[i-1] >= 0){
                subset[i][j] = subset[i-1][j] || subset[i-1][j - arr[i-1]];
            }
            else{
                subset[i][j] = subset[i-1][j];
            }
            cout << i << j <<subset[i][j] << " ";
        }
        cout << endl;
    }
    return subset[arr.size()-1][sum-1];
}

int main(){
    vector<int> arr{2,3,7,8,10};
    int sum = 11;
    bool isThereASubSet = subsetSUm(arr,sum);
    cout << "can we make a subset out of this set with given sum: " << isThereASubSet;
    return 0;
}