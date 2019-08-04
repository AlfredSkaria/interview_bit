#include<iostream>

using std::cout;
using std::endl;

struct Node{
    struct Node *left, *right;
    int data;
};


Node* newNode(int val){
    struct Node *temp = new Node();
    temp->data = val;
    temp->left = temp->right = NULL;
    return temp;
}

Node* findLCA(Node *root, int n1, int n2){

    if(root == NULL){
        return NULL;
    }

    if(root->data == n1 || root->data == n2){
        return root;
    }

    Node *leftLCA = findLCA(root->left,n1,n2);
    Node *rightLCA = findLCA(root->right,n1,n2);

    if(leftLCA && rightLCA){
        return root;
    }

    return (leftLCA != NULL) ? leftLCA : rightLCA;
}

int main(){

    struct Node *root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
    root->right->left = newNode(6);
    root->right->right = newNode(7);

    cout << "LCA of(4,5): " << findLCA(root,4,5)->data;
    cout << "LCA of(7,5): " << findLCA(root,7,5)->data;
    cout << "LCA of(2,1): " << findLCA(root,2,1)->data;
    return 0;
}