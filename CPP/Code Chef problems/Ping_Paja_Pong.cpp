#include <iostream>

using std::cout;
using std::cin;
using std::endl;


int main(){
    int testCases,x,y,k,total,quot;
    unsigned int i;
    cin >> testCases;
    for(i = 0; i < testCases; i++){
        cin >> x >> y >> k;
        total = x + y;
        quot = total / k;
        if(quot % 2 == 0){
            cout << "Chef" << endl;
        }
        else{
            cout << "Paja" << endl;
        }
    }
    return 0;
}