#include <iostream>
#include <algorithm>
#include <vector>

using std::cout;
using std::vector;
using std::endl;
using std::max;

int longestCommonSubSequence(vector<char> word1, vector<char> word2){
    cout << "word1 size: " << word1.size();
    cout << " word2 size: " << word2.size() <<"\n";
    vector<vector<int>> sequence(word1.size()+1,vector<int>(word2.size()+1));
    unsigned int i,j;
    for(i=0; i<word1.size(); i++){
        sequence[i][0] = 0;
    }
    for(j=0; j<word2.size(); j++){
        sequence[0][j] = 0;
    }
    for(i = 1; i<word1.size() + 1; i++){
        for(j = 1; j<word2.size() + 1; j++){
            if(word1[i-1] == word2[j-1]){
                sequence[i][j] = sequence[i-1][j-1] + 1;
            }
            else{
                sequence[i][j] = max(sequence[i][j-1], sequence[i-1][j]);
            }
            cout << sequence[i][j]<<"("<<i<<j<<word1[i-1]<<word2[j-1]<<") ";
        }
        cout <<"\n";
    }
    return sequence[word1.size()][word2.size()];
}

int main(){
    cout << "Longest common sub sequence" << endl;
    vector<char> word1{'a','b','c','d','a','f'};
    vector<char> word2{'a','c','b','c','f'};
    int length = longestCommonSubSequence(word1,word2);
    cout << "Length of common subsequence: " << length << endl;
    return 0;
}