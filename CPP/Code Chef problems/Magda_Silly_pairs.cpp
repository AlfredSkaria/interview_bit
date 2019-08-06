///Question

/*Chef and his friend Magda have 2N mutual friends: N of these friends are chefs and the other N are chefettes. 
The chefs are numbered 1 through N and the chefettes are (independently) also numbered 1 through N. 
Since Magda wants their friends to be as happy as possible and to preserve traditional family values, 
she wants to pair them up in such a way that each chef is paired with exactly one chefette 
and each chefette with exactly one chef.
The chefs have heights A1,A2,…,AN and the chefettes have heights B1,B2,…,BN. 
For each valid i,j, if the i-th chef and the j-th chefette are paired, they will have exactly one child with height ⌊Ai+Bj2⌋. 
Magda wants to pair up the chefs and chefettes in such a way that the sum of heights of all their 
children (N children in total) is maximum possible. Please help her do that.*/

#include <iostream>
#include <vector>

using std::cout;
using std::cin;
using std::vector;
using std::endl;

int main(){
    vector<int> chef;
    vector<int> cheffette;
    int n,testCases,maxHeight = 0, height,a,b,k;
    unsigned int i,j;

    cin >> testCases;
    for(i = 0; i < testCases; i++){
        cin >> n;
        height = 0;
        maxHeight = 0;
        for(j = 0; j < n; j++){
            cin >> a;
            chef.push_back(a);
        }
        for(j = 0; j < n; j++){
            cin >> b;
            cheffette.push_back(b);
        }

        for(k = 0; k < n; k++){
            height = 0;
            for(j = 0; j < n; j++){

                //height = ((chef[0] + cheffette[j%n])/2 + (chef[1] + cheffette[(j+1)%n])/2 + (chef[2] + cheffette[(j+2)%n])/2);
                height = height + (chef[j] + cheffette[(k+j)%n])/2; 
                if(height > maxHeight){
                    maxHeight = height;
                }
            }
        }
        cout << maxHeight;
    }

    

    return 0;
}
