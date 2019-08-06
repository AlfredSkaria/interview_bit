#include<iostream>

using namespace std;

struct Node{
    int data;
    Node *next;
};

Node *node(int data){
    Node *temp = new Node();
    temp->data = data;
    temp->next = NULL;
    return temp;
}


class LinkedList{
    private:
        Node *head, *tail;
    public:
        LinkedList(){
            head = NULL;
            tail = NULL;
        }

        void createNode(int data){
            struct Node *temp = new Node;
            temp->data = data;
            temp->next = NULL;
                if(head == NULL){
                    head = temp;
                    tail = temp;
                    temp = NULL;
                }
                else{
                    tail->next = temp;
                    tail = temp;
                }
        }

        void display(){
            Node *temp = new Node;
            temp = head;
            while(temp != NULL){
                cout << temp->data << " ";
                temp = temp->next;
            }
        }
};


int main(){
    
    int data, i, n;
    cout << "Enter the number of nodes:";
    cin>>n;
    LinkedList l;
        for(i = 0; i<n; i++){
            cin>>data;
            l.createNode(data);
        }
        l.display();
    return 0;
}
