#include<iostream>
#include<queue>
#include<cstring>

using namespace std;

struct Node{
    int x,y,dist;
};

int row[4] = {-1,0,0,1};
int col[4] = {0,1,-1,0};

bool isValid(int s1,int s2, int i, int j, char maze[][5]){
    return s1 > 0 && s2 > 0 && maze[s1][s2] != '#' && maze[i][j] != NULL && maze[i][j] != '#';
}

void BFS(char maze[][5],int s1, int s2, int d1, int d2){
    bool visited[5][5];
    int distance = 0,a,b;
    memset(visited, false, sizeof(visited));
    queue<Node> q;
    Node node;
    node.x = s1;
    node.y = s2;
    node.dist = 0;
    q.push(node);
        while(!q.empty()){
            Node temp = q.front();
            q.pop();
            a = temp.x;
            b = temp.y;
            if(temp.x == d1 && temp.y ==d2){
                //return 
            }
            for(int i = 0; i < 4; i++){
                if(isValid(a, b, a + row[i], b + col[i], maze)){
                    temp.dist = temp.dist + 1;
                    temp.x = a + row[i];
                    temp.y = b + col[i];
                    q.push(temp);
                }
            }

        }

}

void displayMaze(char maze[][5]){
    for(int i = 0; i<5; i++){
        for(int j=0; j<5; j++){
            cout << maze[i][j] <<" ";
        }
        cout << "\n";
    }
}

int main(){

    char maze[][5] = {
                            {'.','.','.','.','.'},
                            {'.','.','#','.','.'},
                            {'#','.','.','#','.'},
                            {'.','#','.','.','.'},
                            {'.','.','#','.','.'}    
                      };
    displayMaze(maze);
    BFS(maze,1,3,3,3);
    return 0;
}