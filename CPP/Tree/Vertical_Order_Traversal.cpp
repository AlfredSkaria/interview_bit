#include<iostream>
#include<vector>

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
    

    return ;
}

int main(){

    Node *root = newNode(10);
    root->left = newNode(5);
    root->right = newNode(15);
    root->left->left = newNode(3);
    root->left->right = newNode(8);
    root->right->left = newNode(12);
    root->right->left = newNode(18);

    printVerticalOrder(root);
    return 0;
}