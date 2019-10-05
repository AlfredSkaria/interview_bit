// Implementation of Kadane's algorithm

#include<iostream>
#include<vector>
#include<algorithm>
#include<stack>

using namespace std;
stack<int> st;

int kadanesAlgo(vector<int> vec){
    int i = 0,j,currentSum = 0,maxSum = 0,temp = -1;
    
    st.push(i);
    for(i = 0; i < vec.size(); i++){
        //cout << vec[i] << " ";
        currentSum = currentSum + vec[i];

        currentSum = max(currentSum, 0);

        maxSum = max(maxSum,currentSum);

        if(temp != maxSum && st.top() != i-1){
            st.push(i);
        }

        temp = maxSum;

    }
    return maxSum;
}

int main(){
    vector<int> vec = {1,-2,3,-9,4,5,-2,6,-7,2};
    cout<<"The maximum sum of the sub array : " << kadanesAlgo(vec) << "\n";
    int startIndex, endIndex;
    endIndex = st.top();
    st.pop();
    startIndex = st.top();
    for(int i = startIndex; i <= endIndex; i++){
        cout << vec[i] << " ";
    }
    return 0;
}