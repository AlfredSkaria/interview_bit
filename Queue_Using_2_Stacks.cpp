#include<iostream>
#include<stack>

using namespace std;


/*This is an implementation of Queue using two stacks. 
There are actually two ways to implement. 
1) Having Enqueue operation (O(n)) costlier than Dequeue operation O(1)
2) Having Dequeue operation (O(n)) costlier than Enqueue operation O(1)
Below is an implementation of the 1st approach */
struct Que{
    stack<int> s1,s2;

    void enqueue(int val){
        while(!s1.empty()){
            s2.push(s1.top());
            s1.pop();
        }
        
        if(s1.empty()){
            s1.push(val);
        }

        while(!s2.empty()){
            s1.push(s2.top());
            //cout << s1.top();
            s2.pop();
        }

    }

    void dequeue(){
        if(s1.empty() && s2.empty()){
            cout<<"No elements in queue";
        }

        s1.pop();
    }

};


int main(){

    Que q;
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(50);

    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();

    return 0;
}