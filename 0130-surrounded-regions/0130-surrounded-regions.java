class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0 || j==0 || i==board.length-1||j==board[0].length-1){
                    if(board[i][j]=='O')
                    {
                        dfs(board,i,j);
                    }
                }
            }
           
        }
         for(int i=0;i<board.length;i++)
            {
                for(int j=0;j<board[0].length;j++)
                {
                    if(board[i][j]=='Y')
                    board[i][j]='O';
                    else
                    board[i][j]='X';
                }
            }
        
    }
    private void dfs(char board[][], int i, int j){
        if(i<0 || j<0 || i>=board.length ||j>=board[0].length || board[i][j]=='X' || board[i][j]=='Y')
        return ;
        board[i][j]='Y';
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i-1,j);
        dfs(board,i,j-1);
    }
}