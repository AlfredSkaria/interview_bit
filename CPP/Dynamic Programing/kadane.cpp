// Implementation of Kadane's algorithm

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int kadanesAlgo(vector<int> vec){
    int i = 0,j,currentSum = 0,maxSum = 0;

    for(i = 0; i < vec.size(); i++){
        //cout << vec[i] << " ";
        currentSum = currentSum + vec[i];

        currentSum = max(currentSum, 0);

        maxSum = max(maxSum,currentSum);
    }
    return maxSum;
}

int main(){
    vector<int> vec = {1,-2,3,-9,4,5,-2,6,-7,2};
    cout<<"The maximum sum of the sub array : " << kadanesAlgo(vec);
    return 0;
}