#include <iostream>
#include <algorithm>
#include <vector>
#include <limits.h>
using namespace std;

int main() {
    int cases, N, i,j;
    
    
	cin >> cases;
	for(j = 0; j < cases; j++){
	    int MAX = INT_MIN;
        int temp,ai,bi;
        vector<int> A;
        vector<int> B;
	    cin>>N;
	    for(i = 0; i < N; i++){
	        cin>>ai;
	        A.push_back(ai);
	    }
	    for(i = 0; i < N; i++){
	        cin>>bi;
	        B.push_back(bi);
	    }
	    for(i = 0; i < N; i++){
	        temp = (A[i]*20) - (B[i]*10);
            cout<<"TEMP: " << temp << " " ;
	        MAX =  max(MAX,temp);
            cout <<"## MAX:  " << MAX <<" " <<endl;
	    }
	    if(MAX < 0){
	        cout << "0" << endl;
	    }
	    else{
	        cout << MAX << endl;
	    }
	}
	    
	return 0;
}