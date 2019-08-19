#include <iostream>
using namespace std;

int main() {
	int cases,i,j;
	long long N,K;
	cin>>cases;
	    for(i = 0; i < cases; i++){
	        cin >> N >> K;
	        
	        if(K == 1){
	            cout << "NO"<<endl;
	            continue;
	        }
	        else if(N < K*K){
	            cout << "YES"<<endl;
	            continue;
	        }
	        else if((K*K)%N == 0){
	            cout << "NO"<<endl;
	            continue;
	        }
	        else if((K*K)%N != 0){
	           cout << "YES"<<endl;
	           continue;
	        }
	    }
	return 0;
}
