#include<iostream>
#include<vector>
#include<queue>
#include<map>
using namespace std;

struct Node{
    int data;
    struct Node *left, *right;
};

Node *newNode(int data){
    Node *temp = new Node();
    temp->data = data;
    temp->left = temp->right = NULL;
    return temp;
}

void printVerticalOrder(Node *root){
    if(root == NULL) return;

    int hd = 0;
    queue<pair<int, Node *>> que;
    que.push(make_pair(hd,root));
    map<int, vector<int>> result;
        while(!que.empty()){
            pair<int, Node*> temp = que.front();
            hd = temp.first;
            Node *node = temp.second;
            que.pop();
            result[hd].push_back(node->data);

            if(node->left != NULL){
                que.push(make_pair(hd-1,node->left));
            }
            if(node->right != NULL){
                que.push(make_pair(hd+1,node->right));
            }
        }

        for(auto it : result){
            for(int i = 0; i<it.second.size(); i++){
                cout << it.second[i] << " ";
            }
            cout << endl;
        }
    return ;
}

int main(){

    Node *root = newNode(10);
    root->left = newNode(5);
    root->right = newNode(15);
    root->left->left = newNode(3);
    root->left->right = newNode(8);
    root->right->left = newNode(12);
    root->right->right = newNode(18);

    printVerticalOrder(root);
    return 0;
}