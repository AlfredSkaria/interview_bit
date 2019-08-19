/*Chef went to the store in order to buy one can of coke. In the store, they offer N cans of coke (numbered 1 through N). For each valid i, the current temperature of the i-th can is Ci and its price is Pi.

After buying a can of coke, Chef wants to immediately start walking home; when he arrives, he wants to immediately drink the whole can. It takes Chef M minutes to get home from the store.

The ambient temperature outside is K. When a can of coke is outside, its temperature approaches the ambient temperature. Specifically, if its temperature is t at some point in time:

if t>K+1, then one minute later, its temperature will be t−1
if t<K−1, then one minute later, its temperature will be t+1
if K−1≤t≤K+1, then one minute later, its temperature will be K
When Chef drinks coke from a can, he wants its temperature to be between L and R (inclusive). Find the cheapest can for which this condition is satisfied or determine that there is no such can.
*/


#include<iostream>
#include<vector>
#include <limits.h>


using namespace std;

int main(){
    int cases,i,j,N,M,K,L,R,mod_temp,final_temp,min = INT_MAX,k;
    long P,C;
    bool flag = false;
    vector<vector<long>> temp_cost;
    cin >> cases;
    for(i = 0; i < cases; i++){
        flag = false;
        cin >> N >> M >> K >> L >> R;
        for(j = 0; j < N; j++){
            vector<long> row;
            cin >> C >> P;
            row.push_back(C);
            row.push_back(P);
            temp_cost.push_back(row); 
        }

        for(j = 0; j < N; j++){
            if(temp_cost[j][0] - M >= K + 1){
                mod_temp = temp_cost[j][0] - M;
            }
            else if(temp_cost[j][0] + M <= K - 1){
                mod_temp = temp_cost[j][0] + M;
            }
            else{
                mod_temp = K;
            }

            //cout << "mod_temp" << mod_temp << endl;
            if(L <= mod_temp && mod_temp <= R){
                if(temp_cost[j][1] < min){
                    min = temp_cost[j][1];
                    flag = true;
                }
            }
        }
        

        // for(j = 0; j < N; j++){
        //     cout << temp_cost[j][0] << " "<< temp_cost[j][1]<< " ";
        //     cout << endl;
        // }
        if(flag){
            cout << min;
        }
        else{
            cout << "-1";
        }
    }
    return 0;
}