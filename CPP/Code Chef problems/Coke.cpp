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